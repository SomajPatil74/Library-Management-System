package com.LibraryManagementSystem.library.service.IMPL;

import com.LibraryManagementSystem.library.dto.AuthorDTO;
import com.LibraryManagementSystem.library.dto.PublisherDTO;
import com.LibraryManagementSystem.library.dto.PublisherSaveDTO;
import com.LibraryManagementSystem.library.dto.PublisherUpdateDTO;
import com.LibraryManagementSystem.library.entity.Author;
import com.LibraryManagementSystem.library.entity.Publisher;
import com.LibraryManagementSystem.library.repo.PublisherRepo;
import com.LibraryManagementSystem.library.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PublisherServiceIMPL implements PublisherService {
    @Autowired
    private PublisherRepo publisherRepo;
    @Override
    public String addPublisher(PublisherSaveDTO publisherSaveDTO) {
        Publisher publisher = new Publisher(
                publisherSaveDTO.getName()
        );
        publisherRepo.save(publisher);
        return publisher.getName();
    }

    @Override
    public List<PublisherDTO> getAllPublisher() {
        List<Publisher> getPublishers = publisherRepo.findAll();
        List<PublisherDTO> publisherDTOList = new ArrayList<>();

        for (Publisher publisher : getPublishers){
            PublisherDTO publisherDTO = new PublisherDTO(
                    publisher.getPublisherid(),
                    publisher.getName()
            );
            publisherDTOList.add(publisherDTO);
        }
        return publisherDTOList;
    }

    @Override
    public String updatePublisher(PublisherUpdateDTO publisherUpdateDTO) {
        if(publisherRepo.existsById(publisherUpdateDTO.getPublisherid())){
            Publisher publisher = publisherRepo.getById(publisherUpdateDTO.getPublisherid());
            publisher.setName(publisherUpdateDTO.getName());

            publisherRepo.save(publisher);
            return publisher.getName();
        }
        else {
            System.out.println("Publisher not exists!!!!!!");
        }
        return null;
    }

    @Override
    public String deletePublisher(int id) {
        if(publisherRepo.existsById(id)){
            publisherRepo.deleteById(id);
        }
        else{
            System.out.println("ID not found!!!!");
        }
        return null;
    }
}
