package net.skillfactory.springPractice.models;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Integer id;

    @NotBlank(message = "Name should not be empty")
    @Pattern(regexp = "[a-zA-Z]+", message = "Name should contain only letters")
    @Size(min = 2, max = 40, message = "Invalid size for name")
    @Column(name = "name")
    private String name;

    @NotBlank(message = "Last name should not be empty")
    @Pattern(regexp = "[a-zA-Z]+", message = "Last name should contain only letters")
    @Size(min = 2, max = 40, message = "Invalid size for last name")
    @Column(name = "last_name")
    private String lastName;

    @NotBlank
    @Pattern(regexp = "[0-9]+", message = "Dni should be made up of numbers")
    @Size(min = 7, max = 8, message = "Invalid size for Dni")
    @Column(name = "dni")
    private String dni;

    @NotNull
    @Min(value = 0, message = "Age not valid")
    @Max(value = 170, message = "Age should not be greater than 170")
    @Column(name = "age")
    private Integer age;

    @Column(name = "country_code") // I don't validate this because the environment variable will set it
    private String countryCode;
}
