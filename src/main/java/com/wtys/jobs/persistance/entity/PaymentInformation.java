package com.wtys.jobs.persistance.entity;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentInformation {
    private Integer reference;
    private Integer amount;
    @Field("payment_currency")
    private String paymentCurrency;
    @Field("payment_date")
    private Date paymentDate;
}
