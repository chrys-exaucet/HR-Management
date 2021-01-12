package org.human.resources.repository.hr;

import org.human.resources.domain.hr.employee.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {

    Employee findByFirstName(String firstname);
    Employee findByLastName(String lastname);
    Employee findByEmail(String email);

}
