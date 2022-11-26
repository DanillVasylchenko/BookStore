package com.example.bookstore.services;

import com.example.bookstore.entities.Book;
import com.example.bookstore.exceptions.BookNotFoundException;
import com.example.bookstore.repositories.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    //Побачити усі книги на продаж
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }
    //Отримати інформацію про конкретну книгу
    public Book getBook(String id) throws Exception {
        return bookRepository.findById(id).orElseThrow(Exception::new);
    }
    //Додавання нової книги у магазин
    public Book addNewBook(Book book){
        return bookRepository.save(book);
    }
    //Редагування опису книги
    public Book editBook(Book book, String id){
        book.setId(id);
        return bookRepository.save(book);
    }
    //Видалення книги з магазину
    public void deleteBook(String id){
        bookRepository.deleteById(id);
    }
}
