package net.skillfactory.springPractice.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class InvalidFieldResponse {

    String field;

    Object rejectedValue;

    String message;
}
