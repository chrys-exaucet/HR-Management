package org.human.resources.domain.hr.employee;


import lombok.*;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Document(collection = "employee")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Manager extends Employee {

    @DBRef(db = "employee")
    private Set<String> employees;

}
