package com.example.NetConnect.Nodes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.List;

@Node
public class Person {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String dob;
    private String location;
    private String currentPosition;
    private int yearsOfExperience;
    private List<String> education;
    private List<String> interests;

    @Relationship(type = "HAS_SKILL", direction = Relationship.Direction.OUTGOING)
    private List<SkillRelation> skills = new ArrayList<>();

    public Person() {

    }

    public Person(String name, String dob, String location, String currentPosition, int yearsOfExperience, List<String> education, List<String> interests) {
        this.name = name;
        this.dob = dob;
        this.location = location;
        this.currentPosition = currentPosition;
        this.yearsOfExperience = yearsOfExperience;
        this.education = education;
        this.interests = interests;
    }

    public void setSkills(List<SkillRelation> skills){
        this.skills=skills;
    }

    public List<SkillRelation> getSkills(){
        return skills;
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

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(String currentPosition) {
        this.currentPosition = currentPosition;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public List<String> getEducation() {
        return education;
    }

    public void setEducation(List<String> education) {
        this.education = education;
    }

    public List<String> getInterests() {
        return interests;
    }

    public void setInterests(List<String> interests) {
        this.interests = interests;
    }

}
