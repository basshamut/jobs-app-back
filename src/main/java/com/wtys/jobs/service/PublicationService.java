package com.wtys.jobs.service;

import com.wtys.jobs.persistance.entity.Publication;
import com.wtys.jobs.service.mapper.PublicationMapper;
import com.wtys.jobs.service.mapper.dto.DataDTO;
import com.wtys.jobs.service.mapper.dto.PublicationDTO;
import com.wtys.jobs.persistance.repository.DocumentJobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicationService {

    @Autowired
    private DocumentJobRepository documentJobRepository;

    public List<PublicationDTO> findAll() {
        List<Publication> jobs = documentJobRepository.findAll();
        return PublicationMapper.toPublicationDTOList(jobs);
    }

    public PublicationDTO findJobById(final String id) {
        Publication job = documentJobRepository.findById(id).orElse(new Publication());
        return PublicationMapper.toPublicationDTO(job);
    }

    public PublicationDTO save(PublicationDTO publicationDTO){
        return PublicationMapper.toPublicationDTO(documentJobRepository.save(PublicationMapper.toPublication(publicationDTO)));
    }
}
