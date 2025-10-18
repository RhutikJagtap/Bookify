package com.bookify.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bookify.entity.Book;
import com.bookify.repository.BookRepository;
import com.bookify.service.BookService;

@Service
public class BookServiceImpl implements BookService{
	
	private BookRepository bookRepository;

	public BookServiceImpl(BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}

	@Override
	public List<Book> getAllBooks() {
		List<Book> allBooks = bookRepository.findAll();
		return allBooks;
	}

	@Override
	public boolean saveBook(Book book) {
		
		Book savedBook = bookRepository.save(book);
		
		if (savedBook.getBookId()!=null) {
			return true;
		}
		
		return false;
	}

	@Override
	public Book getBookById(Integer bookId) {
		
		return bookRepository.getById(bookId);
	}

	@Override
	public void deleteBookById(Integer bookId) {
		bookRepository.deleteById(bookId);
	}

	@Override
	public boolean updateBookById(Integer bookId) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
