package com.brennan.apirest.Person;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons") // Corregido el path para que sea consistente
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @PostMapping
    public void createPerson(@RequestBody Person person) {
        personService.createPerson(person);
    }

    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable("id") int id) {
        return personService.getPersonById(id);
    }

    @GetMapping
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    @PutMapping("/{id}")
    public void updatePerson(@PathVariable("id") int id, @RequestBody Person updatedPerson) {
        personService.updatePerson(id, updatedPerson);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable("id") int id) {
        personService.deletePerson(id);
    }
}
