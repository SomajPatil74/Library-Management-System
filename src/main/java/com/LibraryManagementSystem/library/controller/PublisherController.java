package com.LibraryManagementSystem.library.controller;

import com.LibraryManagementSystem.library.dto.*;
import com.LibraryManagementSystem.library.entity.Publisher;
import com.LibraryManagementSystem.library.service.AuthorService;
import com.LibraryManagementSystem.library.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/publisher")
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    @PostMapping(path = "/save")
    public String savePublisher(@RequestBody PublisherSaveDTO publisherSaveDTO){
        String publishername = publisherService.addPublisher(publisherSaveDTO);
        return "Record added Successfully!!";
    }

    @GetMapping(path = "/getAllPublisher")
    public List<PublisherDTO> getAllPublisher(){
        List<PublisherDTO> allPublishers = publisherService.getAllPublisher();
        return allPublishers;
    }

    @PutMapping(path = "/update")
    public String updatePublisher(@RequestBody PublisherUpdateDTO publisherUpdateDTO){
        String publishername = publisherService.updatePublisher(publisherUpdateDTO);
        return publishername;
    }

    @DeleteMapping(path = "/delete/{id}")
    public String deletePublisher(@PathVariable(value = "id")int id){
        String publishername = publisherService.deletePublisher(id);
        return "deleted";
    }
}
