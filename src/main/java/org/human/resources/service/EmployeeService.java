package org.human.resources.service;


import org.human.resources.domain.hr.employee.Employee;
import org.human.resources.repository.hr.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }

    public Employee findByLastName(String lastName){
        return  employeeRepository.findByLastName(lastName);
    }

    public void save(Employee employee){
        employeeRepository.save(employee);
    }


    public void update( Employee employee){
        Optional<Employee> ancientEmployee =  employeeRepository.findById(employee.getId());
       if( ancientEmployee.isPresent()) {
           this.save(employee);
       }

    }

    public void  delete( Employee employee){
        employeeRepository.delete(employee);

    }


}
