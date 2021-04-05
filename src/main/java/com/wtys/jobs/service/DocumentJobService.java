package com.wtys.jobs.service;

import com.wtys.jobs.persistance.entity.DocumentJob;
import com.wtys.jobs.service.mapper.DocumentJobMapper;
import com.wtys.jobs.service.mapper.dto.DataDTO;
import com.wtys.jobs.service.mapper.dto.DocumentJobDTO;
import com.wtys.jobs.exceptions.ServiceException;
import com.wtys.jobs.persistance.repository.DocumentJobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.wtys.jobs.util.Constants.NOT_FOUND_CODE;
import static com.wtys.jobs.util.Constants.NOT_FOUND_MESSAGE;

@Service
public class DocumentJobService {

    @Autowired
    private DocumentJobRepository documentJobRepository;

    public DataDTO<List<DocumentJobDTO>> findAll() {
        List<DocumentJob> jobs = documentJobRepository.findAll();
        return new DataDTO<>(DocumentJobMapper.toDocumentJobDTOList(jobs));
    }

    public DataDTO<DocumentJobDTO> findJobById(final String id) {
        DocumentJob job = documentJobRepository.findById(id).orElse(new DocumentJob());
        return new DataDTO<>(DocumentJobMapper.toDocumentJobDTO(job));
    }
}
