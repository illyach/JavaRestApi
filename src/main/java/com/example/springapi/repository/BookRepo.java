package com.example.springapi.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.springapi.models.Book;


@Repository
public interface BookRepo extends JpaRepository<Book, Integer> {
    

}
