package com.example.Version1.Service;

import com.example.Version1.Service.BookService;
import com.example.Version1.model.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();
    Book getBookByIsbn(String isbn);
    Book createBook(Book book);
    Book updateBook(String isbn, Book book);
    void deleteBook(String isbn);
}
