package com.LibraryManagementSystem.library.repo;

import com.LibraryManagementSystem.library.entity.Author;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepo extends JpaRepository<Author, Integer> {
}
