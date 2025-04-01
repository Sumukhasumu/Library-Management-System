package com.library.service;

import com.library.model.Users;
import com.library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class responsible for handling user-related operations such as
 * authentication and adding new users.
 */
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	/**
	 * Authenticates a user based on their username and password.
	 * 
	 * @param username the username of the user attempting to authenticate
	 * @param password the password of the user attempting to authenticate
	 * @return Users object if authentication is successful, or null if
	 *         authentication fails
	 */
	public Users authenticate(String username, String password) {
		// Fetch user by username
		Users users = userRepository.findByUsername(username);

		// Check if the user exists and the password matches
		if (users != null && users.getPassword().equals(password)) {
			return users;
		}

		// Return null if authentication fails
		return null;
	}

	/**
	 * Adds a new user to the system.
	 * 
	 * @param users the Users object containing the details of the user to be added
	 * @return the saved Users object
	 */
	public Users addUser(Users users) {
		// Save and return the user object after adding it to the database
		return userRepository.save(users);
	}
}
