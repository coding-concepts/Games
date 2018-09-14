package org.ccs.rest.facade.impl;

import org.ccs.rest.DataBase;
import org.ccs.rest.facade.PersonFacade;
import org.ccs.rest.model.response.Person;
import org.springframework.stereotype.Component;

@Component
public class PersonFacadeImpl implements PersonFacade {

    @Override
    public Iterable getFolks() {
        return DataBase.getFolks();
    }

    @Override
    public Person addPerson(String name) {
        return DataBase.add(name);
    }

    @Override
    public Person getPerson(Long visitorId) {
        return DataBase.getPerson(visitorId);
    }


}
