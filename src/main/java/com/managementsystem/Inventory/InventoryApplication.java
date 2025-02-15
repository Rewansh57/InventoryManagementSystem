package com.managementsystem.Inventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/*
com.managementsystem.Inventory
│
├── config
│   └── SecurityConfig.java       // Configures Spring Security(main problem arises here for looping endpoints)
│
├── controller
│   ├── AuthController.java       // Handles signup and (optional to counter nullpointer exception) login endpoints
│   └── ItemController.java       // Handles CRUD endpoints and fuzzy search for items
│
├── model
│   ├── Item.java                 // Represents an inventory item entity(quantity ,etc details)
│   └── User.java                 // Represents a user entity (with username, email, password)
│
├── repository
│   ├── ItemRepository.java       // JPA repositories(uses spring data JPA ,hibernate for persistance)
│   └── UserRepository.java       
│
├── service
│   ├── ItemService.java          // Contains business logic for items (CRUD & fuzzy search)
│   ├── UserService.java          // Contains business logic for user registration
│   └── CustomUserDetailsService.java  // Loads user details for Spring Security
│
└── DemoApplication.java          // Main Spring Boot application class(The build tool is MAVEN)
*/
public class InventoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryApplication.class, args);
	}

}
