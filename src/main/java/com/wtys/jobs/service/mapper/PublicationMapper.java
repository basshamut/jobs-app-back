package com.wtys.jobs.service.mapper;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.wtys.jobs.persistance.entity.Description;
import com.wtys.jobs.persistance.entity.PaymentInformation;
import com.wtys.jobs.persistance.entity.Publication;
import com.wtys.jobs.persistance.entity.UserInformation;
import com.wtys.jobs.service.mapper.dto.DescriptionDTO;
import com.wtys.jobs.service.mapper.dto.PaymentInformationDTO;
import com.wtys.jobs.service.mapper.dto.PublicationDTO;
import com.wtys.jobs.service.mapper.dto.UserInformationDTO;

public class PublicationMapper {

    private PublicationMapper() {
        throw new IllegalStateException("Utility Class");
    }

    public static List<Publication> toPublicationList(Collection<PublicationDTO> list) {
        if (list == null) {
            return Collections.emptyList();
        }
        return list.stream()
            .map(PublicationMapper::toPublication)
            .collect(Collectors.toList());
    }

    public static Publication toPublication(PublicationDTO dto) {
        return Publication.builder()
            .id(dto.getId())
            .title(dto.getTitle())
            .salary(dto.getSalary())
            .isoCurrency(dto.getIsoCurrency())
            .symbolCurrency(dto.getSymbolCurrency())
            .publicationDate(dto.getPublicationDate())
            .description(toDescription(dto.getDescription()))
            .userInformation(toUserInformation(dto.getUserInformation()))
            .build();
    }

    private static Description toDescription(DescriptionDTO dto) {
        return Description.builder()
            .summary(dto.getSummary())
            .build();
    }

    private static UserInformation toUserInformation(final UserInformationDTO dto) {
        return UserInformation.builder()
            .email(dto.getEmail())
            .name(dto.getName())
            .paymentInformation(toPaymentInformation(dto.getPaymentInformation()))
            .build();
    }

    private static PaymentInformation toPaymentInformation(PaymentInformationDTO dto) {
        return PaymentInformation.builder()
            .amount(dto.getAmount())
            .paymentCurrency(dto.getPaymentCurrency())
            .paymentDate(dto.getPaymentDate())
            .reference(dto.getReference())
            .build();
    }

    public static List<PublicationDTO> toPublicationDTOList(Collection<Publication> list) {
        if (list == null) {
            return Collections.emptyList();
        }
        return list.stream()
            .map(PublicationMapper::toPublicationDTO)
            .collect(Collectors.toList());
    }

    public static PublicationDTO toPublicationDTO(Publication entity) {
        return PublicationDTO.builder()
            .id(entity.getId())
            .title(entity.getTitle())
            .salary(entity.getSalary())
            .isoCurrency(entity.getIsoCurrency())
            .symbolCurrency(entity.getSymbolCurrency())
            .publicationDate(entity.getPublicationDate())
            .description(toDescriptionDTO(entity.getDescription()))
            .userInformation(toUserInformationDTO(entity.getUserInformation()))
            .build();
    }

    private static DescriptionDTO toDescriptionDTO(Description description) {
        return DescriptionDTO.builder().summary(description.getSummary()).build();
    }

    private static UserInformationDTO toUserInformationDTO(UserInformation entity) {
        return UserInformationDTO.builder()
            .email(entity.getEmail())
            .name(entity.getName())
            .paymentInformation(toPaymentInformationDTO(entity.getPaymentInformation()))
            .build();
    }

    private static PaymentInformationDTO toPaymentInformationDTO(PaymentInformation entity) {
        return PaymentInformationDTO.builder()
            .amount(entity.getAmount())
            .paymentCurrency(entity.getPaymentCurrency())
            .paymentDate(entity.getPaymentDate())
            .reference(entity.getReference())
            .build();
    }
}
