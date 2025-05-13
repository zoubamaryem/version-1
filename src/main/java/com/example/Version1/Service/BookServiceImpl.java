package com.example.Version1.Service;


import com.example.Version1.Repository.BookRepository;
import com.example.Version1.model.Book;
import com.example.Version1.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookByIsbn(String isbn) {
        return bookRepository.findById(isbn)
                .orElseThrow(() -> new RuntimeException("Book not found"));
    }

    @Override
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(String isbn, Book book) {
        Optional<Book> existing = bookRepository.findById(isbn);
        if (existing.isEmpty()) throw new RuntimeException("Book not found");

        Book updated = existing.get();
        updated.setTitle(book.getTitle());
        updated.setAuthor(book.getAuthor());
        return bookRepository.save(updated);
    }

    @Override
    public void deleteBook(String isbn) {
        if (!bookRepository.existsById(isbn))
            throw new RuntimeException("Book not found");
        bookRepository.deleteById(isbn);
    }
}
