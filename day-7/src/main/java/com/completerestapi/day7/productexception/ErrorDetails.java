package com.completerestapi.day7.productexception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class ErrorDetails {
    private Boolean success;
    private String message;
}
