package com.LibraryManagementSystem.library.service;

import com.LibraryManagementSystem.library.dto.BookDTO;
import com.LibraryManagementSystem.library.dto.BookSaveDTO;
import com.LibraryManagementSystem.library.dto.BookUpdateDTO;

import java.util.List;

public interface BookService {
    String addBook(BookSaveDTO bookSaveDTO);
    List<BookDTO> getAllBook();
    String updateBook(BookUpdateDTO bookUpdateDTO);
    String deleteBook(int id);
}
