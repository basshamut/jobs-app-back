package com.wtys.jobs.controller;

import com.wtys.jobs.service.PublicationService;
import com.wtys.jobs.service.mapper.dto.DataDTO;
import com.wtys.jobs.service.mapper.dto.PublicationDTO;
import com.wtys.jobs.util.Constants;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@WebMvcTest(PublicationController.class)
public class PublicationControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PublicationService publicationService;

    @Test
    public void shouldHTTPCodeOk200() throws Exception{
        final List<PublicationDTO> publicationDTOList = new ArrayList<>();

        Mockito.when(publicationService.findAll()).thenReturn(publicationDTOList);

        mockMvc.perform(get( "/" + Constants.URL_SERVICE + Constants.JOBS).header("Origin","*"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());    }
}
