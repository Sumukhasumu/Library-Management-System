package com.library.repository;

import com.library.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for performing CRUD operations on the Users entity. This
 * extends JpaRepository to leverage its built-in methods for database
 * interactions.
 */
public interface UserRepository extends JpaRepository<Users, Long> {

	/**
	 * Finds a user by their username. This method uses the derived query method
	 * convention of Spring Data JPA.
	 * 
	 * @param username the username of the user to search for
	 * @return the user associated with the given username, or null if no user is
	 *         found
	 */
	Users findByUsername(String username);
}
