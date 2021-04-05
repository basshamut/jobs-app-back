package com.wtys.jobs.service.mapper;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.wtys.jobs.persistance.entity.Description;
import com.wtys.jobs.persistance.entity.DocumentJob;
import com.wtys.jobs.service.mapper.dto.DescriptionDTO;
import com.wtys.jobs.service.mapper.dto.DocumentJobDTO;

public class DocumentJobMapper {

    private DocumentJobMapper() {
        throw new IllegalStateException("Utility Class");
    }

    public static List<DocumentJob> toDocumentJobList(Collection<DocumentJobDTO> list) {
        if (list == null) {
            return Collections.emptyList();
        }
        return list.stream()
            .map(DocumentJobMapper::toDocumentJob)
            .collect(Collectors.toList());
    }

    public static DocumentJob toDocumentJob(DocumentJobDTO dto) {
        return DocumentJob.builder()
            .id(dto.getId())
            .title(dto.getTitle())
            .salary(dto.getSalary())
            .isoCurrency(dto.getIsoCurrency())
            .symbolCurrency(dto.getSymbolCurrency())
            .publicationDate(dto.getPublicationDate())
            .description(toDescription(dto.getDescription()))
            .build();
    }

    private static Description toDescription(DescriptionDTO dto) {
        return Description.builder()
            .summary(dto.getSummary())
            .build();
    }

    public static List<DocumentJobDTO> toDocumentJobDTOList(Collection<DocumentJob> list) {
        if (list == null) {
            return Collections.emptyList();
        }
        return list.stream()
            .map(DocumentJobMapper::toDocumentJobDTO)
            .collect(Collectors.toList());
    }

    public static DocumentJobDTO toDocumentJobDTO(DocumentJob entity) {
        return DocumentJobDTO.builder()
            .id(entity.getId())
            .title(entity.getTitle())
            .salary(entity.getSalary())
            .isoCurrency(entity.getIsoCurrency())
            .symbolCurrency(entity.getSymbolCurrency())
            .publicationDate(entity.getPublicationDate())
            .description(toDescriptionDTO(entity.getDescription()))
            .build();
    }

    private static DescriptionDTO toDescriptionDTO(Description description) {
        return DescriptionDTO.builder().summary(description.getSummary()).build();
    }
}
