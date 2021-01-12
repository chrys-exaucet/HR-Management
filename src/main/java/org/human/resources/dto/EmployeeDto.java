package org.human.resources.dto;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.data.mongodb.core.mapping.DBRef;

import javax.persistence.Id;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@ApiModel(value = "Employee", description = "Represents an employee, either a manager or a simple one")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

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

