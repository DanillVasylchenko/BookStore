package com.example.bookstore.controllers;

import com.example.bookstore.entities.Book;
import com.example.bookstore.services.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@AllArgsConstructor
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;
    //Побачити усі книги на продаж
    @GetMapping
    public ResponseEntity<?> getAllBooks(){
        return ResponseEntity.ok().body(bookService.getAllBooks());
    }
    //Отримати інформацію про конкретну книгу
    @GetMapping("/{id}")
    public ResponseEntity<?> getBook(@PathVariable String id) throws Exception {
        return ResponseEntity.ok().body(bookService.getBook(id));
    }
    //Додавання нової книги у магазин
    @PostMapping("/new-book")
    public ResponseEntity<?> addNewBook(@RequestBody Book book){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/books/new-book").toUriString());
        return ResponseEntity.created(uri).body(bookService.addNewBook(book));
    }
    //Редагування опису книги
    @PatchMapping("/edit-book/{id}")
    public ResponseEntity<?> editBook(@RequestBody Book book, @PathVariable String id){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/books/edit-book").toUriString());
        return ResponseEntity.created(uri).body(bookService.editBook(book, id));
    }
    //Видалення книги з магазину
    @DeleteMapping ("/delete-book/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable String id){
        bookService.deleteBook(id);
        return ResponseEntity.ok().body(HttpStatus.OK);
    }
}