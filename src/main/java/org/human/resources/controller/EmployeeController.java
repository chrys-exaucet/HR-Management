package org.human.resources.controller;

import org.human.resources.dto.EmployeeDto;
import org.human.resources.mapper.EmployeeMapper;
import org.human.resources.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static java.util.stream.Collectors.toList;


@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private  EmployeeService employeeService;

    private final EmployeeMapper mapper = EmployeeMapper.INSTANCE;


    @GetMapping("/get")
    public List<EmployeeDto> getAllEmployee() {
        return employeeService.findAll().stream().map(
            mapper::toDto
        ).collect(toList());
    }

    @GetMapping(path = "/get/{name}",
        consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
        produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public EmployeeDto getEmployeeByName(@PathVariable String name) {
        return mapper.toDto(employeeService.findByLastName(name));
    }


    @PostMapping(path = "/create", consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<EmployeeDto> saveEmployee(@Valid @RequestBody EmployeeDto dto) {
        employeeService.save(mapper.fromDto(dto));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @PutMapping(path = "/update",
        consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<EmployeeDto> updateEmployee(@Valid @RequestBody EmployeeDto dto) {
        employeeService.update(mapper.fromDto(dto));
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @DeleteMapping(path = "/delete", consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<EmployeeDto> deleteEmployee(@Valid @RequestBody EmployeeDto dto) {
        employeeService.delete(mapper.fromDto(dto));
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
