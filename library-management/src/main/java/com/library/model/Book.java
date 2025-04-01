package com.library.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Represents a Book entity in the library system. This class is mapped to the
 * 'book' table in the database using JPA annotations.
 */
@Entity
public class Book {

	/**
	 * The unique ID of the book. This field is the primary key and is
	 * auto-generated.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * The title of the book. This field stores the name of the book.
	 */
	private String title;

	/**
	 * The author of the book. This field stores the name of the author of the book.
	 */
	private String author;

	/**
	 * The year the book was published. This field stores the published year of the
	 * book.
	 */
	@Column(name = "published_year")
	private Integer publishedYear;

	/**
	 * Indicates whether the book is issued or not. This field holds a boolean
	 * value: true if the book is issued, false otherwise.
	 */
	@Column(name = "is_issued", nullable = false)
	private Boolean isIssued;

	// Getters and Setters

	/**
	 * Gets the unique ID of the book.
	 * 
	 * @return the ID of the book.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the unique ID of the book.
	 * 
	 * @param id the ID to set.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the title of the book.
	 * 
	 * @return the title of the book.
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title of the book.
	 * 
	 * @param title the title to set.
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Gets the author of the book.
	 * 
	 * @return the author of the book.
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * Sets the author of the book.
	 * 
	 * @param author the author to set.
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * Gets the published year of the book.
	 * 
	 * @return the published year.
	 */
	public Integer getPublishedYear() {
		return publishedYear;
	}

	/**
	 * Sets the published year of the book.
	 * 
	 * @param publishedYear the published year to set.
	 */
	public void setPublishedYear(Integer publishedYear) {
		this.publishedYear = publishedYear;
	}

	/**
	 * Gets the issued status of the book.
	 * 
	 * @return true if the book is issued, false otherwise.
	 */
	public Boolean getIsIssued() {
		return isIssued;
	}

	/**
	 * Sets the issued status of the book.
	 * 
	 * @param isIssued the issued status to set.
	 */
	public void setIsIssued(Boolean isIssued) {
		this.isIssued = isIssued;
	}

	/**
	 * Returns a string representation of the book, displaying the title and author.
	 * This method is overridden to provide a more meaningful output when the book
	 * object is printed.
	 * 
	 * @return a string with the book's title and author.
	 */
	@Override
	public String toString() {
		return title + " by " + author; // Display title and author in the dropdown
	}
}
