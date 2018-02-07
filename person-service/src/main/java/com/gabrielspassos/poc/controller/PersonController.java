package com.gabrielspassos.poc.controller;

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
}
