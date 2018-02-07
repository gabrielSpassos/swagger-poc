package com.gabrielspassos.poc.dao;

import com.gabrielspassos.poc.model.PersonModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonDAO {

    List<PersonModel> peopleList = new ArrayList<>();

    public PersonDAO() {
        peopleList.add(new PersonModel(1,"Gabriel","Passos",20));
        peopleList.add(new PersonModel(2,"Leo","Messi",35));
        peopleList.add(new PersonModel(3,"Tom","Brady",40));
        peopleList.add(new PersonModel(4,"Jose","Silva",27));
        peopleList.add(new PersonModel(5,"Maria","Bonita",24));
    }

    public List<PersonModel> getPeopleList() {
        return peopleList;
    }

}
