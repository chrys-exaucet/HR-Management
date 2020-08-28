package org.human.resources.repository;

import org.human.resources.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {

    Employee findByFirstName(String firstname);
    Employee findByLastName(String lastname);
    Employee findByEmail(String email);

}
