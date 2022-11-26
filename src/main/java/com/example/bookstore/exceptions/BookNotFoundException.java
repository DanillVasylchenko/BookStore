package com.example.bookstore.exceptions;


public class BookNotFoundException extends Exception{
    public BookNotFoundException(String id){
        super("book by id " + id + "not found");
    }
}
