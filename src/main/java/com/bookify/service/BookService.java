package com.bookify.service;

import java.util.List;

import com.bookify.entity.Book;

public interface BookService {
	
	public List<Book> getAllBooks();
	
	public boolean saveBook(Book book);
	
	public Book getBookById(Integer bookId);
	
	public void deleteBookById(Integer bookId);
	
	public boolean updateBookById(Integer bookId);

}
