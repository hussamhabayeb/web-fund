package com.example.club.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.club.models.Book;
import com.example.club.repositories.BookRepository;

@Service
public class BookService {

	@Autowired
	  private BookRepository bookRepository;
	
	
	 // returns all the Book
    public List<Book> allBooks() {
        return  bookRepository.findAll();
    }
    // creates a Book
    public Book createBook(Book b) {
        return  bookRepository.save(b);
    }
    // retrieves a Book
    public Book findBook(Long id) {
        Optional<Book> optionalBook =  bookRepository.findById(id);
        if( optionalBook.isPresent()) {
            return  optionalBook.get();
        } else {
            return null;
        }
    }
	
    
    public Book updateBook(Book book) {
		return bookRepository.save(book);
	}
	
    public void  deleteBook(Long id) {
		 bookRepository.deleteById(id);
		}
	
}
