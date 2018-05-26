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

    public PersonModel deletePersonById(int id){
        return peopleList.remove(getArrayIndexByPersonId(id));
    }

    public PersonModel savePerson(PersonModel personModel) {
        peopleList.add(personModel);
        return peopleList.get(peopleList.indexOf(personModel));
    }

    public PersonModel updatePerson(PersonModel personModel) {
        int position = getArrayIndexByPersonId(personModel.getId());
        deletePersonById(personModel.getId());
        peopleList.add(position, personModel);
        return personModel;
    }

    private int getArrayIndexByPersonId(int id){
        int arrayIndex = 999999999;
        for (PersonModel person: peopleList) {
            if(person.getId() == id){
                arrayIndex = peopleList.indexOf(person);
            }
        }
        return arrayIndex;
    }
}
