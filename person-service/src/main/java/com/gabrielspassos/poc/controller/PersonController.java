package com.gabrielspassos.poc.controller;

import com.gabrielspassos.poc.model.PersonModel;
import com.gabrielspassos.poc.service.PersonService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
                    message="Retorna um PersonModel com uma mensagem de sucesso",
                    response=PersonModel.class
            ),
            @ApiResponse(
                    code=500,
                    message="Caso tenhamos algum erro vamos retornar um Error com a Exception",
                    response=Error.class
            )

    })
    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET)
    public PersonModel getPersonById(@PathVariable("id") int id){
        return personService.getPersonById(id);
    }
}
