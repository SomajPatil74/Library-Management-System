package com.LibraryManagementSystem.library.service;

import com.LibraryManagementSystem.library.dto.PublisherDTO;
import com.LibraryManagementSystem.library.dto.PublisherSaveDTO;
import com.LibraryManagementSystem.library.dto.PublisherUpdateDTO;

import java.util.List;

public interface PublisherService {
    String addPublisher(PublisherSaveDTO publisherSaveDTO);
    List<PublisherDTO> getAllPublisher();
    String updatePublisher(PublisherUpdateDTO publisherUpdateDTO);
    String deletePublisher(int id);
}
