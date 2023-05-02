package com.example.book.services;

import java.util.List;
import java.util.Optional;

//...
import org.springframework.stereotype.Service;

import com.example.book.models.Book;
import com.example.book.repositories.BookRepository;
@Service
public class BookService {

 private final BookRepository bookRepository;
 
 public BookService(BookRepository bookRepository) {
     this.bookRepository = bookRepository;
 }

 public List<Book> allBooks() {
     return bookRepository.findAll();
 }

 public Book createBook(Book b) {
     return bookRepository.save(b);
 }

 public Book findBook(Long id) {
     Optional<Book> optionalBook = bookRepository.findById(id);
     if(optionalBook.isPresent()) {
         return optionalBook.get();
     } else {
         return null;
     }
 }
public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
	Book book= findBook(id);
	book.setTitle(title);
	book.setDescription(desc);
	book.setLanguage(lang);
	book.setNumberOfPages(numOfPages);
	book=bookRepository.save(book);
	return book;
}
public void deleteBook(Long id) {
	bookRepository.deleteById(id);
	
}
}

