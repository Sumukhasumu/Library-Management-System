package com.library.repository;

import com.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository interface for performing CRUD operations on the Book entity. This
 * extends JpaRepository to leverage its built-in methods for database
 * interactions.
 */
public interface BookRepository extends JpaRepository<Book, Long> {

	/**
	 * Finds all books that match the specified issue status (issued or not).
	 * 
	 * @param isIssued a Boolean value representing the issue status (true for
	 *                 issued, false for not issued)
	 * @return a list of books that match the issue status
	 */
	List<Book> findByIsIssued(Boolean isIssued);

	/**
	 * Finds books whose titles contain the specified substring. This method uses
	 * the derived query method convention of Spring Data JPA.
	 * 
	 * @param title a substring to search for in book titles
	 * @return a list of books whose titles contain the given substring
	 */
	List<Book> findByTitleContaining(String title);
}
