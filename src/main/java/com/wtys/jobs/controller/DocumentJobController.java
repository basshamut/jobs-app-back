package com.wtys.jobs.controller;

import com.wtys.jobs.service.mapper.dto.DataDTO;
import com.wtys.jobs.service.mapper.dto.DocumentJobDTO;
import com.wtys.jobs.service.DocumentJobService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.wtys.jobs.util.Constants.URL_SERVICE;

@RestController("documentJobController")
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = URL_SERVICE)
public class DocumentJobController {

    @Autowired
    private DocumentJobService documentJobService;

    @Autowired
    private HttpServletResponse response;

    private Logger logger = LoggerFactory.getLogger(DocumentJobController.class);

    @GetMapping("/jobs")
    @ResponseBody
    public ResponseEntity<DataDTO<List<DocumentJobDTO>>> findAll() {
        final DataDTO<List<DocumentJobDTO>> dataDTO = documentJobService.findAll();

        dataDTO.setCode(String.valueOf(HttpStatus.OK.value()));
        dataDTO.setMessage(HttpStatus.OK.name());

        return ResponseEntity.ok()
            .body(dataDTO);
    }

    @GetMapping("/jobs/{id}")
    @ResponseBody
    public ResponseEntity<DataDTO<DocumentJobDTO>> findJobById(@PathVariable("id") final String id) {
        final DataDTO<DocumentJobDTO> dataDTO = documentJobService.findJobById(id);

        dataDTO.setCode(String.valueOf(HttpStatus.OK.value()));
        dataDTO.setMessage(HttpStatus.OK.name());

        return ResponseEntity.ok()
            .body(dataDTO);
    }
}
