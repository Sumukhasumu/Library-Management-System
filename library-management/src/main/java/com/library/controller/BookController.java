package com.library.controller;

import com.library.model.Book;
import com.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping("/issue")
	public String showIssueForm(Model model) {
		// Get available books that are not yet issued
		List<Book> availableBooks = bookService.getAvailableBooks();
		model.addAttribute("books", availableBooks);
		return "issue"; // The page where you display the dropdown to issue books
	}

	@PostMapping("/issue")
	public String issueBook(@RequestParam Long bookId, Model model) {
		try {
			// Issue the selected book
			bookService.issueBook(bookId);

			// Get the updated list of available books (those that are not yet issued)
			List<Book> availableBooks = bookService.getAvailableBooks();
			model.addAttribute("books", availableBooks);

			// Add a success message
			model.addAttribute("message", "Book issued successfully!");
		} catch (Exception e) {
			// Add an error message if something goes wrong
			model.addAttribute("message", "Error: " + e.getMessage());
		}

		return "issue"; // Return to the issue page with the updated dropdown
	}

	@GetMapping("/return")
	public String showReturnForm(Model model) {
		List<Book> books = bookService.getIssuedBooks();
		model.addAttribute("books", books);
		return "return";
	}

	@PostMapping("/return")
	public String handleReturn(@RequestParam("bookId") Long bookId, Model model) {
		try {
			// Process the return logic
			bookService.returnBook(bookId);

			// Add a success message
			model.addAttribute("message", "Book returned successfully!");
		} catch (Exception e) {
			// Add an error message if something goes wrong
			model.addAttribute("message", "Error: " + e.getMessage());
		}

		// Update the dropdown with the remaining issued books
		List<Book> books = bookService.getIssuedBooks();
		model.addAttribute("books", books);

		return "return"; // Return the updated JSP view
	}

	@GetMapping("/list")
	public String showList(Model model) {
		List<Book> books = bookService.getAllBooks();
		model.addAttribute("books", books);
		return "list";
	}

	@GetMapping("/search")
	public String showSearchForm(String title, Model model) {
		List<Book> books = bookService.searchBook(title); // Or any default list if needed
		model.addAttribute("books", books);
		return "search"; // This returns the search form view
	}

	@GetMapping("/add")
	public String showAddForm() {
		return "addbooks";
	}

	@PostMapping("/add")
	public String addBook(@ModelAttribute Book book, Model model) {
		bookService.addBook(book);
		model.addAttribute("successMessage", "Book added successfully!");
		return "addbooks";
	}
}
