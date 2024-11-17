package com.LibraryManagementSystem.library.dto;

import com.LibraryManagementSystem.library.entity.Author;
import com.LibraryManagementSystem.library.entity.Publisher;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookDTO {
    private int bookid;
    private String title;
    private Author author;
    private Publisher publisher;
}
