package org.nil.learning.controller;

import org.nil.learning.model.Book;
import org.nil.learning.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@PostMapping("/book")
	public void addBook() {
		Book book = new Book("1001", "Elasticsearch Basics", "Rambabu Posa", "23-FEB-2017");
		Book testBook = bookService.save(book);
	}
	
	@GetMapping("/book/{bookId}")
	public Book getBook(@PathVariable("bookId") String bookId) {
		return bookService.findOne(bookId);
	}
}
