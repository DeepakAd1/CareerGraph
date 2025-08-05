package com.example.NetConnect.Nodes;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.List;

@Node
public class Skill {

    @Id
    @GeneratedValue
    private Long id;
    private String name; // e.g., "Java"
    private String certification; // e.g., "Oracle Certified Java Programmer"
    private String proficiencyLevel; // e.g., "Intermediate"
    private int yearsOfExperience;

    @Relationship(type = "REQUIRED_FOR", direction = Relationship.Direction.OUTGOING)
    private List<RequiredFor> requiredFor = new ArrayList<>();


    public Skill() {
    }

    public Skill(String name, String certification, String proficiencyLevel, int yearsOfExperience) {
        this.name = name;
        this.certification = certification;
        this.proficiencyLevel = proficiencyLevel;
        this.yearsOfExperience = yearsOfExperience;
    }

    public List<RequiredFor> getRequiredFor() {
        return requiredFor;
    }

    public void setRequiredFor(List<RequiredFor> requiredFor) {
        this.requiredFor = requiredFor;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCertification() {
        return certification;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }

    public String getProficiencyLevel() {
        return proficiencyLevel;
    }

    public void setProficiencyLevel(String proficiencyLevel) {
        this.proficiencyLevel = proficiencyLevel;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }
}
