package com.wtys.jobs.service.mapper.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentInformationDTO {

    private Integer reference;
    private Integer amount;
    private String paymentCurrency;
    private Date paymentDate;
}
