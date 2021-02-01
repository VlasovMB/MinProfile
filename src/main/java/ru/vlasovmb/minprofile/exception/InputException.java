package ru.vlasovmb.minprofile.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
public class InputException extends RuntimeException {
    private BindingResult bindingResult;

    public ErrorsDto getErrorsDto(){
       Map<String, List<String>> errors = bindingResult
                .getAllErrors()
                .stream()
                .collect(Collectors.groupingBy(
                        nameError -> nameError.getObjectName(),
                        Collectors.mapping(message -> message.getDefaultMessage(), Collectors.toList())
                ));
       TreeMap<String,List<String>> sortedErrors = new TreeMap<>(errors);
       return ErrorsDto.builder()
               .errors(sortedErrors)
               .message("Input error")
               .build();
    }

}
