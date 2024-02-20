package br.com.ajxtech.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.ajxtech.models.Person;
import br.com.ajxtech.services.PersonServices;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonServices service = new PersonServices();
	//private PersonServices service = new PersonServices();
	
	@GetMapping(produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public List<Person> findAll() { 
		
		return service.findAll();
	}
	
	@GetMapping(value="/{id}",produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public Person findById(@PathVariable(value = "id") Long id) { 
		
		return service.findById(id);
	}
	
	@PostMapping(
			consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE,
			produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public Person create(@RequestBody Person person) { 
		
		return service.create(person);
	}
	
	@PutMapping(
			consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE,
			produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public Person update(@RequestBody Person person) { 
		
		return service.update(person);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) { 
		
		service.delete(id);
		
		return ResponseEntity.noContent().build();
	}
	
}
