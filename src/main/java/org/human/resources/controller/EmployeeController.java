package org.human.resources.controller;

import org.human.resources.model.Employee;
import org.human.resources.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @GetMapping("/get")
    public List<Employee> getAllEmployee(){
        return employeeService.findAll();
    }

    @GetMapping(path = "/get/{name}",
            consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public Employee getEmployeeByName( @PathVariable  String name){
            return  employeeService.findByLastName(name);
    }


    @PostMapping(path="/create", consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee employee){
        employeeService.save(employee);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @PutMapping(path = "/update",
            consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Employee> updateEmployee(@Valid @RequestBody Employee employee){
        employeeService.update(employee);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @DeleteMapping(path = "/delete", consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Employee> deleteEmployee(@Valid @RequestBody Employee employee){
         employeeService.delete(employee);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
