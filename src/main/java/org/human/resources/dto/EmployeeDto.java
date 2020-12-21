package org.human.resources.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

    @Id
    private String id;

    @NotNull
    @Size(min = 4, message = "Enter at least 4 characters for the first name.")
    private String firstName;

    @NotNull
    @Size(min = 4, message = "Enter at least 4 characters for the last name.")
    private String lastName;

    @Email
    @NotBlank
    private String email;

}

