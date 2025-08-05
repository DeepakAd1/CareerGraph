package com.example.NetConnect.Nodes;

import org.springframework.data.neo4j.core.schema.*;

import java.sql.Date;

@RelationshipProperties
public class Knows {

    @Id
    @GeneratedValue
    private Long id;

    private int strength;

    private Date since;

    private String context;   // e.g., "college", "previous job", etc.

    @TargetNode
    private Person person;

    public Knows() {
    }

    public Knows(int strength, Date since, String context, Person person) {
        this.strength = strength;
        this.since = since;
        this.context = context;
        this.person = person;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public Date getSince() {
        return since;
    }

    public void setSince(Date since) {
        this.since = since;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}

