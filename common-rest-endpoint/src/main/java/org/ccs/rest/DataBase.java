package org.ccs.rest;

import org.ccs.rest.model.response.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class DataBase {
    private static HashMap<Long, Person> visitorToPerson = new HashMap<>();
    private static HashMap<String, Person> nameToPerson = new HashMap<>();

    private static final AtomicLong counter = new AtomicLong(visitorToPerson.size());

    public static Iterable getFolks() {
        List<Person> personList = new ArrayList<>();
        for (Long l : visitorToPerson.keySet()){
            personList.add(visitorToPerson.get(l));
        }
        return personList;
    }

    public static Person add(String name){
        if (!nameToPerson.containsKey(name)){
            Person p = Person.builder().name(name).visitorNumber(counter.incrementAndGet()).build();
            visitorToPerson.put(p.getVisitorNumber(),p);
            nameToPerson.put(name, p);
        }

        return nameToPerson.get(name);
    }

    public static Person getPerson(Long visitorId){
        return visitorToPerson.get(visitorId);
    }

}
