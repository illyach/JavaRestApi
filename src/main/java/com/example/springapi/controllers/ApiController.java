package com.example.springapi.controllers;

import com.example.springapi.models.Book;
import com.example.springapi.repository.BookRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin
@RequiredArgsConstructor
public class ApiController {

    private final BookRepo bookRepo;
    private final ObjectMapper objectMapper;

    @SneakyThrows
    @GetMapping("my-api/app")
    public List<Book> getAll() {
        return bookRepo.findAll();
    }


    @PostMapping("my-api/add")
    public void addBook(@RequestBody Book book) {
        log.info("New row: " + bookRepo.save(book));
    }
}