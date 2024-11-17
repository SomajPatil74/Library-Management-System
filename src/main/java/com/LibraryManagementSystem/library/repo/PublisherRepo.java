package com.LibraryManagementSystem.library.repo;

import com.LibraryManagementSystem.library.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepo extends JpaRepository<Publisher, Integer> {
}
