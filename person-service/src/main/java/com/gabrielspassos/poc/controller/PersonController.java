package com.gabrielspassos.poc.controller;

import com.gabrielspassos.poc.controller.dto.PersonDto;
import com.gabrielspassos.poc.model.PersonModel;
import com.gabrielspassos.poc.service.PersonService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/people")
public class PersonController {

    @Autowired
    PersonService personService;

    @ApiOperation(
            value="Get a person by id",
            response=PersonModel.class,
            notes="Essa operação pega as informações de uma pessoa.")
    @ApiResponses(value= {
            @ApiResponse(
                    code=200,
                    message="Retorna um PersonModel",
                    response=PersonModel.class
            ),
            @ApiResponse(
                    code=404,
                    message="Caso tenhamos algum erro vamos retornar uma mensagem de erro",
                    response=Error.class
            )

    })
    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET)
    public PersonModel getPersonById(@PathVariable("id") int id){
        return personService.getPersonById(id);
    }

    @ApiOperation(
            value="Get all people",
            response=PersonModel.class,
            notes="Essa operação pega as informações de todas as pessoas.")
    @ApiResponse(
            code=200,
            message="Retorna uma lista de pessoas",
            response=PersonModel.class)
    @GetMapping
    public List<PersonModel> getAllPerson(){
        return personService.getAllPerson();
    }

    @ApiOperation(
            value = "Deleta pessoa pelo seu id",
            response = PersonModel.class,
            notes = "Essa operação deleta uma pessoa"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Retorna PersonModel deletado",
                    response = PersonModel.class
            ),
            @ApiResponse(
                    code = 404,
                    message = "Caso tenhamos algum erro vamos retornar uma mensagem de erro",
                    response = Error.class
            )
    })
    @DeleteMapping(value = "/{id}")
    public PersonModel deletePersonById(@PathVariable("id") int id){
        return personService.deletePersonById(id);
    }

    @ApiOperation(
            value = "Salva pessoa",
            response = PersonModel.class,
            notes = "Essa operação salva uma pessoa"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 201,
                    message = "Retorna PersonModel inserido",
                    response = PersonModel.class
            )
    })
    @PostMapping
    public PersonModel savePerson(@RequestBody PersonDto personDto){
        return personService.savePerson(convertToModel(personDto));
    }

    @ApiOperation(
            value = "Atualiza pessoa",
            response = PersonModel.class,
            notes = "Essa operação salva uma pessoa"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Retorna PersonModel inserido",
                    response = PersonModel.class
            )
    })
    @PutMapping(value = "/{id}")
    public PersonModel updatePerson(@PathVariable("id") int id, @RequestBody PersonDto personDto){
        return personService.updatePerson(id, convertToModel(personDto));
    }

    private PersonModel convertToModel(PersonDto personDto){
        PersonModel personModel = new PersonModel();
        personModel.setId(personDto.getId());
        personModel.setName(personDto.getName());
        personModel.setLastName(personDto.getLastName());
        personModel.setAge(personDto.getAge());
        return personModel;
    }
}
