package com.LibraryManagementSystem.library.service;

import com.LibraryManagementSystem.library.dto.AuthorDTO;
import com.LibraryManagementSystem.library.dto.AuthorSaveDTO;
import com.LibraryManagementSystem.library.dto.AuthorUpdateDTO;

import java.util.List;

public interface AuthorService {
    String addAuthor(AuthorSaveDTO authorSaveDTO);
    List<AuthorDTO> getAllAuthor();
    String updateAuthor(AuthorUpdateDTO authorUpdateDTO);
    String deleteAuthor(int id);
}
