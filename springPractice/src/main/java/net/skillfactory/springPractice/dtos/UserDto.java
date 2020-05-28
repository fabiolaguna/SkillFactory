package net.skillfactory.springPractice.dtos;

import lombok.Data;

@Data
public class UserDto {

    private String name;
    private String lastName;
    private String dni;
    private Integer age;

}
