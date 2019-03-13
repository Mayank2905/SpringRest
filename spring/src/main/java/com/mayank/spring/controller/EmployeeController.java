package com.mayank.spring.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mayank.spring.exception.ResourceNotFoundException;
import com.mayank.spring.model.Employee;
import com.mayank.spring.repository.EmployeeRepository;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	@Autowired
   EmployeeRepository empRepository;
	
	@GetMapping("/getallemployee")
	public List<Employee> getAllNotes() {
	    return empRepository.findAll();
	}
	
	@PostMapping("/insert")
	public Employee createNote(@Valid @RequestBody Employee emp) {
	    return empRepository.save(emp);
	}
	
	@GetMapping("/employee/{id}")
	public Employee getNoteById(@PathVariable(value = "id") Long noteId) {
	    return empRepository.findById(noteId)
	            .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", noteId));
	}

}
