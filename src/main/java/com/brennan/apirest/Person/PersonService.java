package com.brennan.apirest.Person;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.util.ClassUtils.isPresent;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepo;

    public void createPerson(Person person){
        personRepo.save(person);
    }

    public Person getPersonById(int id){
        Optional<Person> personOptional = personRepo.findById(id);
        return personOptional.orElse(null); // Retorna null si no se encuentra la persona
    }

    public List<Person> getAllPersons(){
        return personRepo.findAll();
    }

    public void updatePerson(int id, Person updatedPerson){
        Optional<Person> existingPersonOptional = personRepo.findById(id);
        if (existingPersonOptional.isPresent()) {
            Person existingPerson = existingPersonOptional.get();
            existingPerson.setFirstName(updatedPerson.getFirstName());
            existingPerson.setLastName(updatedPerson.getLastName());
            existingPerson.setEmail(updatedPerson.getEmail());

            personRepo.save(existingPerson); // Guardar los cambios en la base de datos
        }
    }

    public void deletePerson(int id) {
        Optional<Person> personOptional = personRepo.findById(id);

        if (personOptional.isPresent()) {
            Person p = personOptional.get();
            personRepo.delete(p);
        }
    }
}

