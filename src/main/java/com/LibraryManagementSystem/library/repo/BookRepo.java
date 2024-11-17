package com.LibraryManagementSystem.library.repo;

import com.LibraryManagementSystem.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book, Integer> {
}
