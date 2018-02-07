package com.gabrielspassos.poc.service;

import com.gabrielspassos.poc.dao.PersonDAO;
import com.gabrielspassos.poc.exception.IdNotExistException;
import com.gabrielspassos.poc.model.PersonModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonDAO personDAO;

    public PersonService() {
    }

    public void setPersonDAO(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    public PersonModel getPersonById(int id){
        return personDAO.getPeopleList().stream()
                .filter(person -> person.getId() == id)
                .findFirst()
                .orElseThrow(IdNotExistException::new);
    }

    public List<PersonModel> getAllPerson(){
        return personDAO.getPeopleList();
    }
}
