package com.example.springapi.api.controller;

import com.example.springapi.api.repository.BookRepo;
import com.example.springapi.entity.Book;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MainController {

    private final BookRepo bookRepo;
    private final ObjectMapper objectMapper;

    @PostMapping("/api/add")
    public void addCat(@RequestBody Book book) {
        log.info("New row: " + bookRepo.save(book));
    }

    @SneakyThrows
    @GetMapping("/api/all")
    public List<Book> getAll() {
        return bookRepo.findAll();
    }

    @GetMapping("/api") //по id GET запрос
    public Book getCat(@RequestParam int id) {
        return bookRepo.findById(id).orElseThrow();
    }

    @DeleteMapping("/api")
    public void deleteCat(@RequestParam int id) {
        bookRepo.deleteById(id);
    }


    @PutMapping("/api/put")
    public String changeCat(@RequestBody Book book) {
        if(!bookRepo.existsById(book.getId())){
            return "No such row";
        }
        return bookRepo.save(book).toString();
    }

}
