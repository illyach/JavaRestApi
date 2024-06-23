
package com.example.springapi.controllers;

import com.example.springapi.models.Book;
import com.example.springapi.repository.BookRepo;
import com.example.springapi.services.AppService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import com.example.springapi.models.MyUser;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/apps")
@AllArgsConstructor
public class AppController {

    private AppService service;
    private final BookRepo bookRepo;
    private final ObjectMapper objectMapper;



    @PostMapping("/new-user")
    public String addUser(@RequestBody MyUser user) {
        service.addUser(user);
        return "User is saved bro";
    }


    @GetMapping("/all")
    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    @GetMapping("/get")
    @Operation(
            summary = "Get book by ID",
            description = "Returns a book based on the provided ID. Requires the user to have ROLE_USER authority."
    )
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public Book getBookById(@RequestParam int id) {
        return bookRepo.findById(id).orElseThrow();
    }

    @DeleteMapping("/delete")

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public void deleteBook(@RequestParam int id) {
        bookRepo.deleteById(id);
    }

    @PutMapping("/put")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String updateBook(@RequestBody Book book) {
        if (!bookRepo.existsById(book.getId())) {
            return "No such row";
        }
        return bookRepo.save(book).toString();
    }
    @GetMapping("/redirect")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public RedirectView redirectExample() {
        String redirectUrl = "http://localhost:8081/"; // URL, на который вы хотите перенаправить пользователя
        return new RedirectView(redirectUrl);

    }
    
}






