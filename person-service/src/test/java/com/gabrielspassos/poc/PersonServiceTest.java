package com.gabrielspassos.poc;

import com.gabrielspassos.poc.dao.PersonDAO;
import com.gabrielspassos.poc.exception.IdNotExistException;

import com.gabrielspassos.poc.model.PersonModel;
import com.gabrielspassos.poc.service.PersonService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PersonServiceTest {

    PersonService personService;

    @Before
    public void setup(){
        personService = new PersonService();
    }

    @Test
    public void mustReturnPerson() throws IdNotExistException {
        personService.setPersonDAO(new PersonDAO());
        System.out.println(personService);
        PersonModel personModelReturned =  personService.getPersonById(1);
        assertEquals(1,personModelReturned.getId());
        assertEquals("Gabriel",personModelReturned.getName());
        assertEquals("Passos",personModelReturned.getLastName());
        assertEquals(20,personModelReturned.getAge());
    }

    @Test(expected = IdNotExistException.class)
    public void mustThrowIdNotExist() {
        personService.setPersonDAO(new PersonDAO());
        personService.getPersonById(100);
    }
}
