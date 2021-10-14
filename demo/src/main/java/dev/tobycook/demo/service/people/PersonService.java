package dev.tobycook.demo.service.people;

import dev.tobycook.demo.models.person.Person;
import dev.tobycook.demo.repository.people.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Optional<Person> findById(Integer id) {
        return personRepository.findById(id);
    }
}
