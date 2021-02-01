package ru.vlasovmb.minprofile.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data

public class ErrorsDto {
    private String message;
    private Map<String, List<String>> errors;
}
