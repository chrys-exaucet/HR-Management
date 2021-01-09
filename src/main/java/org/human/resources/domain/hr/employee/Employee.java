package org.human.resources.model.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.ZonedDateTime;


@Document(collection = "employee")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    private ObjectId id;

    @NotNull
    @Size(min = 12, message = "Enter at least 12 characters for the first name.")
    private String firstName;

    @NotNull
    @Size(min = 12, message = "Enter at least 12 characters for the last name.")
    private String lastName;

    @Email
    @NotBlank
    private String email;

    private String phoneNumber;

    private ZonedDateTime hireDate;

    private long salary;

    private BigDecimal commissionPercentage;

    @DBRef(db = "employee")
    private ObjectId managerId;

    @DBRef(db = "department")
    private ObjectId departmentId;

}
