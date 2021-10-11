package com.wtys.jobs.service.mapper.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserInformationDTO {

    private String name;
    private String email;

    private PaymentInformationDTO paymentInformation;
}
