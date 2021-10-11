package com.wtys.jobs.persistance.entity;

import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserInformation {
    private String name;
    private String email;

    @Field("payment_information")
    private PaymentInformation paymentInformation;
}
