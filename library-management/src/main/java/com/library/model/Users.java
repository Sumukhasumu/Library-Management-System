package com.library.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Represents a User entity for authentication and user management in the
 * library system. This class is mapped to the 'users' table in the database
 * using JPA annotations.
 */
@Entity
public class Users {

	/**
	 * The unique ID of the user. This field is marked as the primary key and is
	 * auto-generated.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * The username used for user authentication. This field is unique to each user.
	 */
	private String username;

	/**
	 * The password associated with the user. It is used for authentication during
	 * login.
	 */
	private String password;

	/**
	 * Gets the unique ID of the user.
	 * 
	 * @return the ID of the user.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the unique ID of the user.
	 * 
	 * @param id the ID to set.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the username of the user.
	 * 
	 * @return the username.
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Sets the username of the user.
	 * 
	 * @param username the username to set.
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Gets the password of the user.
	 * 
	 * @return the password.
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password of the user.
	 * 
	 * @param password the password to set.
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
