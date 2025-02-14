package com.managementsystem.Inventory.Repository;

import com.managementsystem.Inventory.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
//For database operations
@Repository
public interface UserRepository  extends JpaRepository<User, Long> {
  //Used optional for handling nullpointer exception
  Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);


}
