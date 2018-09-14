package org.ccs.rest.facade;

import org.ccs.rest.model.response.Person;

public interface PersonFacade {
    Iterable getFolks();

    Person addPerson(String name);

    Person getPerson(Long visitorId);
}
