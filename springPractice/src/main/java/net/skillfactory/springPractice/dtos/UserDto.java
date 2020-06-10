package net.skillfactory.springPractice.dtos;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Builder
public class UserDto {

    @Pattern(regexp = "[a-zA-Z]+", message = "Name should contain only letters")
    @Size(min = 2, max = 40, message = "Invalid size for name")
    private String name;

    @Pattern(regexp = "[a-zA-Z]+", message = "Last name should contain only letters")
    @Size(min = 2, max = 40, message = "Invalid size for last name")
    private String lastName;

    @Pattern(regexp = "[0-9]+", message = "Dni should be made up of numbers")
    @Size(min = 7, max = 8, message = "Invalid size for Dni")
    private String dni;

    @Min(value = 0, message = "Age not valid")
    @Max(value = 170, message = "Age should not be greater than 170")
    private Integer age;

    @Pattern(regexp = "[0-9-]+", message = "Country code should be made up of numbers")
    @Size(min = 1, max = 7, message = "Invalid size for country code")
    private String countryCode;
}
