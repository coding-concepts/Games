package org.ccs.rest.model.response;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
/*
Must have setters and getters if this is to be a response.
 */
public class Person  {
    private String name;
    private Long visitorNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getVisitorNumber() {
        return visitorNumber;
    }

    public void setVisitorNumber(Long visitorNumber) {
        this.visitorNumber = visitorNumber;
    }
}
