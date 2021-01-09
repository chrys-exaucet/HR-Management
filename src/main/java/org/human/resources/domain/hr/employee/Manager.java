package org.human.resources.model.employee;


import lombok.*;
import org.bson.types.ObjectId;
import org.human.resources.model.employee.Employee;
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
    private Set<ObjectId> employees;

}
