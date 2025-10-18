package com.bookify.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bookify.entity.Book;
import com.bookify.service.BookService;

@Controller
public class BookController {

	private BookService bookService;

	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	//localhost:8080
	 // ✅ Default home page → list all books
    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "index";   // your Thymeleaf file name (all_books.html)
    }
	

	@GetMapping("/allBooks")
	public ModelAndView allBooksPage() {

		System.out.println("Handler method.................");

		List<Book> allBooks = bookService.getAllBooks();
		ModelAndView mav = new ModelAndView();
		mav.addObject("books", allBooks);

		mav.setViewName("viewBooks");

		return mav;
	}

	@GetMapping("/bookform")
	public ModelAndView loadBookForm() {
		ModelAndView mav = new ModelAndView();
		Book book = new Book();
		mav.addObject("book", book);

		mav.setViewName("addBook");
		System.out.println("Form loading.......................... ");

		return mav;
	}

	@PostMapping("/saveBook")
	public ModelAndView saveBook(Book book) {
		ModelAndView mav = new ModelAndView();

		boolean status = bookService.saveBook(book);

		if (status) {
			mav.addObject("success","Book saved successfully......!");
			System.out.println("Success Msg Book saved successfully");
		} else {
			mav.addObject("error","Book not saved error......!");
			System.out.println("Error Msg Book not saved ");
		}
		List<Book> allBooks = bookService.getAllBooks();
		mav.addObject("books", allBooks);
		mav.setViewName("viewBooks");

		return mav;
	}

	@GetMapping("/deleteBook")
	public ModelAndView deleteBook(@RequestParam("bookId") Integer bookId) {
		bookService.deleteBookById(bookId);
		ModelAndView mav = new ModelAndView();
		
		try {
	        bookService.deleteBookById(bookId);
	        mav.addObject("success", "Book deleted successfully!"); // Success message
	    } catch (Exception e) {
	        mav.addObject("error", "Failed to delete the book!");   // Error message
	    }

		List<Book> allBooks = bookService.getAllBooks();
		mav.addObject("books", allBooks);

		mav.setViewName("viewBooks");

		return mav;
	}

	@GetMapping("/EditBookForm")
	public ModelAndView loadEditBookForm(@RequestParam("bookId") Integer id) {

		Book book = bookService.getBookById(id);

		ModelAndView mav = new ModelAndView();
		mav.addObject("book", book);

		mav.setViewName("editBook");
		System.out.println("Edit Form loading.......................... ");

		return mav;
	}

	@PostMapping("/EditBook")
	public ModelAndView editBook(Book book) {
		ModelAndView mav = new ModelAndView();

		boolean status = bookService.saveBook(book);

		if (status) {
			mav.addObject("success","Book update successfully......!");
			System.out.println("Success Msg Book update successfully");
		} else {
			mav.addObject("error","Book not updated error......!");
			System.out.println("Error Msg Book Not update ");
		}
		List<Book> allBooks = bookService.getAllBooks();
		mav.addObject("books", allBooks);
		mav.setViewName("viewBooks");

		return mav;
	}

}
