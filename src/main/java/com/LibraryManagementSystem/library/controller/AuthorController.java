package com.LibraryManagementSystem.library.controller;

import com.LibraryManagementSystem.library.dto.AuthorDTO;
import com.LibraryManagementSystem.library.dto.AuthorSaveDTO;
import com.LibraryManagementSystem.library.dto.AuthorUpdateDTO;
import com.LibraryManagementSystem.library.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/author")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @PostMapping(path = "/save")
    public String saveAuthor(@RequestBody AuthorSaveDTO authorSaveDTO){
        String authorname = authorService.addAuthor(authorSaveDTO);
        return "Record added Successfully!!";
    }

    @GetMapping(path = "/getAllAuthor")
    public List<AuthorDTO> getAllAuthor(){
        List<AuthorDTO> allAuthors = authorService.getAllAuthor();
        return allAuthors;
    }

    @PutMapping(path = "/update")
    public String updateAuthor(@RequestBody AuthorUpdateDTO authorUpdateDTO){
        String authorname = authorService.updateAuthor(authorUpdateDTO);
        return authorname;
    }

    @DeleteMapping(path = "/delete/{id}")
    public String deleteAuthor(@PathVariable(value = "id")int id){
        String authorname = authorService.deleteAuthor(id);
        return "deleted";
    }
}
