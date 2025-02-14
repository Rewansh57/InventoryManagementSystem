package com.managementsystem.Inventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/*
Project Structure
com.managementsystem.Inventory
│── config
│   └── SecurityConfig.java
│── controller
│   └── ItemController.java
│── model
│   └── Item.java
│── repository
│   └── ItemRepository.java
│── service
│   ├── ItemService.java
│   ├── CustomUserDetailsService.java
│── MainApplication.java
*/
public class InventoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryApplication.class, args);
	}

}
