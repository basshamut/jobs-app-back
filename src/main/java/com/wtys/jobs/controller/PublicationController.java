package com.wtys.jobs.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wtys.jobs.service.PublicationService;
import com.wtys.jobs.service.mapper.dto.DataDTO;
import com.wtys.jobs.service.mapper.dto.PublicationDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.wtys.jobs.util.Constants.URL_SERVICE;

@RestController("documentJobController")
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = URL_SERVICE)
public class PublicationController {

    @Autowired
    private PublicationService publicationService;

    private Logger logger = LoggerFactory.getLogger(PublicationController.class);

    @GetMapping("/publications")
    @ResponseBody
    public ResponseEntity<DataDTO<List<PublicationDTO>>> findAll() {
        final List<PublicationDTO> publicationDTOList = publicationService.findAll();

        if(CollectionUtils.isEmpty(publicationDTOList)){
            return ResponseEntity.notFound().build();
        }

        final DataDTO<List<PublicationDTO>> dataDTO = new DataDTO<>();
        dataDTO.setData(publicationDTOList);
        dataDTO.setCode(String.valueOf(HttpStatus.OK.value()));
        dataDTO.setMessage(HttpStatus.OK.name());

        return ResponseEntity.ok().body(dataDTO);
    }

    @GetMapping("/publications/{id}")
    @ResponseBody
    public ResponseEntity<DataDTO<PublicationDTO>> findPublicationById(@PathVariable("id") final String id) {
        final PublicationDTO publicationDTO = publicationService.findJobById(id);

        if(Objects.isNull(publicationDTO)){
            return ResponseEntity.notFound().build();
        }

        final DataDTO<PublicationDTO> dataDTO = new DataDTO<>();
        dataDTO.setData(publicationDTO);
        dataDTO.setCode(String.valueOf(HttpStatus.OK.value()));
        dataDTO.setMessage(HttpStatus.OK.name());

        return ResponseEntity.ok()
            .body(dataDTO);
    }

    @PostMapping("/publications")
    @ResponseBody
    public ResponseEntity<DataDTO<PublicationDTO>> registerPublication(
        @RequestBody final PublicationDTO publicationDTO) {
        PublicationDTO publicationDTOSaved = publicationService.save(publicationDTO);

        if(Objects.isNull(publicationDTOSaved)){
            return ResponseEntity.noContent().build();
        }

        final DataDTO<PublicationDTO> dataDTO = new DataDTO<>();
        dataDTO.setData(publicationDTOSaved);
        dataDTO.setCode(String.valueOf(HttpStatus.OK.value()));
        dataDTO.setMessage(HttpStatus.OK.name());

        return ResponseEntity.ok()
            .body(dataDTO);
    }

}
