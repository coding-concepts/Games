package org.ccs.rest.api;

import io.swagger.annotations.ApiOperation;
import org.ccs.rest.facade.PersonFacade;
import org.ccs.rest.model.response.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class PersonController {
    @Autowired
    private PersonFacade facade;


    @RequestMapping(value = "/people", method= RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "Get a Person by Name", response = Iterable.class)
    public Iterable person() {
        return facade.getFolks();
    }


    @RequestMapping(value = "/person", method= RequestMethod.POST, produces = "application/json")
    @ApiOperation(value = "Add a person by name", response = Person.class)
    public Person add( String name) {
        return facade.addPerson(name);
    }


    @RequestMapping(value = "/person/{visitorId}", method= RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "Add a person by name", response = Person.class)
    public Person add(@PathVariable("visitorId") Long visitorId) {
        return facade.getPerson(visitorId);
    }


}
