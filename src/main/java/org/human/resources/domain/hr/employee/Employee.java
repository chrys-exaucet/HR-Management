package org.human.resources.domain.hr.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@Document(collection = "employee")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements Serializable {


    @Id
    private String id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @Email
    @NotBlank
    private String email;

    private String phoneNumber;

    private LocalDateTime hireDate;

    @Positive
    private long salary;

    @Positive
    @Max(100)
    private BigDecimal commissionPercentage;

    @DBRef(db = "employee")
    private String managerId;

    @DBRef(db = "department")
    private String departmentId;

}
