package com.wtys.jobs.service.mapper.dto;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.wtys.jobs.persistance.entity.Description;
import com.wtys.jobs.persistance.entity.UserInformation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PublicationDTO {
    private String id;
    private String title;
    private Long salary;
    private String isoCurrency;
    private String symbolCurrency;
    private Long publicationDate;
    private DescriptionDTO description;
    private UserInformationDTO userInformation;
}
