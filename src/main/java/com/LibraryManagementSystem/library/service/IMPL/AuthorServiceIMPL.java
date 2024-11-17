package com.LibraryManagementSystem.library.service.IMPL;

import com.LibraryManagementSystem.library.dto.AuthorDTO;
import com.LibraryManagementSystem.library.dto.AuthorSaveDTO;
import com.LibraryManagementSystem.library.dto.AuthorUpdateDTO;
import com.LibraryManagementSystem.library.entity.Author;
import com.LibraryManagementSystem.library.repo.AuthorRepo;
import com.LibraryManagementSystem.library.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorServiceIMPL implements AuthorService {
    @Autowired
    private AuthorRepo authorRepo;
    @Override
    public String addAuthor(AuthorSaveDTO authorSaveDTO) {
        Author author = new Author(authorSaveDTO.getName());
        authorRepo.save(author);
        return author.getName();
    }

    @Override
    public List<AuthorDTO> getAllAuthor() {
        List<Author> getAuthors = authorRepo.findAll();
        List<AuthorDTO> authorDTOList = new ArrayList<>();

        for (Author author : getAuthors){
            AuthorDTO authorDTO = new AuthorDTO(
                    author.getAuthorid(),
                    author.getName()
            );
            authorDTOList.add(authorDTO);
        }
        return authorDTOList;
    }

    @Override
    public String updateAuthor(AuthorUpdateDTO authorUpdateDTO) {
        if(authorRepo.existsById(authorUpdateDTO.getAuthorid())){
            Author author = authorRepo.getById(authorUpdateDTO.getAuthorid());
            author.setName(authorUpdateDTO.getName());

            authorRepo.save(author);
            return author.getName();
        }
        else {
            System.out.println("Author not exists!!!!!!");
        }
        return null;
    }

    @Override
    public String deleteAuthor(int id) {
        if(authorRepo.existsById(id)){
            authorRepo.deleteById(id);
        }
        else{
            System.out.println("ID not found!!!!");
        }
        return null;
    }
}
