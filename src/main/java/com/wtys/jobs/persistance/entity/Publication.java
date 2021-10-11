package com.wtys.jobs.persistance.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "publications")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Publication {
    @Id
    private String id;
    private String title;
    private Long salary;
    @Field("iso_currency")
    private String isoCurrency;
    @Field("symbol_currency")
    private String symbolCurrency;
    @Field("publication_date")
    private Date publicationDate;

    private Description description;

    @Field("user_information")
    private UserInformation userInformation;

}
