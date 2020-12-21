package org.human.resources.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;




@Document(collection = "employee")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

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
