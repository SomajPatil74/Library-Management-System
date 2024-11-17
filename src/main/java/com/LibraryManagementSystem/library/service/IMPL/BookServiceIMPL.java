package com.LibraryManagementSystem.library.service.IMPL;

import com.LibraryManagementSystem.library.dto.AuthorDTO;
import com.LibraryManagementSystem.library.dto.BookDTO;
import com.LibraryManagementSystem.library.dto.BookSaveDTO;
import com.LibraryManagementSystem.library.dto.BookUpdateDTO;
import com.LibraryManagementSystem.library.entity.Author;
import com.LibraryManagementSystem.library.entity.Book;
import com.LibraryManagementSystem.library.repo.AuthorRepo;
import com.LibraryManagementSystem.library.repo.BookRepo;
import com.LibraryManagementSystem.library.repo.PublisherRepo;
import com.LibraryManagementSystem.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceIMPL implements BookService {
    @Autowired
    private AuthorRepo authorRepo;

    @Autowired
    private PublisherRepo publisherRepo;

    @Autowired
    private BookRepo bookRepo;

    @Override
    public String addBook(BookSaveDTO bookSaveDTO) {
        Book book = new Book(
                bookSaveDTO.getTitle(),
                authorRepo.getById(bookSaveDTO.getAuthor_id()),
                publisherRepo.getById(bookSaveDTO.getPublisher_id())
                );
        bookRepo.save(book);
        return book.getTitle();
    }

    @Override
    public List<BookDTO> getAllBook() {
        List<Book> getBooks = bookRepo.findAll();
        List<BookDTO> bookDTOList = new ArrayList<>();

        for (Book book : getBooks){
            BookDTO bookDTO = new BookDTO(
                    book.getBookid(),
                    book.getTitle(),
                    book.getAuthor(),
                    book.getPublisher()
            );
            bookDTOList.add(bookDTO);
        }
        return bookDTOList;
    }

    @Override
    public String updateBook(BookUpdateDTO bookUpdateDTO) {
        if(bookRepo.existsById(bookUpdateDTO.getBookid())){
            Book book = bookRepo.getById(bookUpdateDTO.getBookid());
            book.setTitle(bookUpdateDTO.getTitle());
            book.setAuthor(authorRepo.getById(bookUpdateDTO.getAuthor_id()));
            book.setPublisher(publisherRepo.getById(bookUpdateDTO.getPublisher_id()));

            bookRepo.save(book);
            return book.getTitle();
        }
        else {
            System.out.println("Book not exists!!!!!!");
        }
        return null;
    }

    @Override
    public String deleteBook(int id) {
        if(bookRepo.existsById(id)){
            bookRepo.deleteById(id);
        }
        else{
            System.out.println("Book not found!!!!");
        }
        return null;
    }
}
