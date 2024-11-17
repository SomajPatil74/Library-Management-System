package com.LibraryManagementSystem.library.repo;

import com.LibraryManagementSystem.library.entity.Publisher;
import com.LibraryManagementSystem.library.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepo extends JpaRepository<User, Integer> {
}
