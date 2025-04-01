package com.library.service;

import com.library.model.Book;
import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Service class responsible for handling book-related operations such as
 * retrieving books, issuing, returning, and adding books.
 */
@Service
public class BookService {

	private static final Logger logger = LoggerFactory.getLogger(BookService.class);

	@Autowired
	private BookRepository bookRepository;

	/**
	 * Retrieves a list of all books in the library.
	 *
	 * @return List of all books
	 */
	public List<Book> getAllBooks() {
		logger.info("Fetching all books from the database.");
		return bookRepository.findAll();
	}

	/**
	 * Retrieves a list of books that are currently issued.
	 *
	 * @return List of issued books
	 */
	public List<Book> getIssuedBooks() {
		logger.info("Fetching all issued books.");
		return bookRepository.findByIsIssued(true);
	}

	/**
	 * Retrieves a list of books that are currently available (not issued).
	 *
	 * @return List of available books
	 */
	public List<Book> getAvailableBooks() {
		logger.info("Fetching all available (not issued) books.");
		return bookRepository.findByIsIssued(false);
	}

	/**
	 * Searches for books by title (partial match).
	 *
	 * @param title the title (or part of the title) to search for
	 * @return List of books whose titles contain the search term
	 */
	public List<Book> searchBook(String title) {
		logger.info("Searching for books with title containing: {}", title);
		return bookRepository.findByTitleContaining(title);
	}

	/**
	 * Issues a book by its ID. A book can only be issued if it is not already
	 * issued.
	 *
	 * @param bookId the ID of the book to be issued
	 * @throws IllegalArgumentException if the book ID is null or the book does not
	 *                                  exist
	 * @throws IllegalStateException    if the book is already issued
	 */
	public void issueBook(Long bookId) {
		if (bookId == null) {
			throw new IllegalArgumentException("Book ID cannot be null");
		}

		Book book = bookRepository.findById(bookId)
				.orElseThrow(() -> new IllegalArgumentException("Book not found with ID: " + bookId));
		if (Boolean.TRUE.equals(book.getIsIssued())) {
			throw new IllegalStateException("Book is already issued: " + book.getTitle());
		}
		book.setIsIssued(true);
		bookRepository.save(book);
		logger.info("Book issued successfully: {}", book.getTitle());
	}

	/**
	 * Returns a book by its ID. A book can only be returned if it was previously
	 * issued.
	 *
	 * @param bookId the ID of the book to be returned
	 * @throws IllegalArgumentException if the book ID is invalid or the book does
	 *                                  not exist
	 * @throws IllegalStateException    if the book is not issued
	 */
	public void returnBook(Long bookId) {
		Book book = bookRepository.findById(bookId)
				.orElseThrow(() -> new IllegalArgumentException("Book not found with ID: " + bookId));
		if (Boolean.FALSE.equals(book.getIsIssued())) {
			throw new IllegalStateException("Book is not issued: " + book.getTitle());
		}
		book.setIsIssued(false);
		bookRepository.save(book);
		logger.info("Book returned successfully: {}", book.getTitle());
	}

	/**
	 * Adds a new book to the library's collection.
	 *
	 * @param book the Book object to be added
	 */
	public void addBook(Book book) {
		bookRepository.save(book);
		logger.info("New book added: {}", book.getTitle());
	}
}