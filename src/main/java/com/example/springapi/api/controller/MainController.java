package com.example.springapi.api.controller;

import com.example.springapi.api.repository.CatRepo;
import com.example.springapi.entity.Cat;
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

    private final CatRepo catRepo;
    private final ObjectMapper objectMapper;

    @PostMapping("/api/add")
    public void addCat(@RequestBody Cat cat) {
        log.info("New row: " + catRepo.save(cat));
    }

    @SneakyThrows
    @GetMapping("/api/all")
    public List<Cat> getAll() {
        return catRepo.findAll();
    }

    @GetMapping("/api") //по id GET запрос
    public Cat getCat(@RequestParam int id) {
        return catRepo.findById(id).orElseThrow();
    }

    @DeleteMapping("/api")
    public void deleteCat(@RequestParam int id) {
        catRepo.deleteById(id);
    }


    @PutMapping("/api/put")
    public String changeCat(@RequestBody Cat cat) {
        if(!catRepo.existsById(cat.getId())){
            return "No such row";
        }
        return catRepo.save(cat).toString();
    }

}
