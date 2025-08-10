package com.example.NetConnect.Nodes;

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
    private long userId;
    private String name;
    private Long dob;
    private String location;
    private String currentPosition;
    private int yearsOfExperience;
    private List<String> education;
    private List<String> interests;

    @Relationship(type = "HAS_SKILL", direction = Relationship.Direction.OUTGOING)
    private List<SkillRelation> skills = new ArrayList<>();

    @Relationship(type = "WORKS_AT", direction = Relationship.Direction.OUTGOING)
    private List<WorksAt> worksAt = new ArrayList<>();

    @Relationship(type = "WORKS_AS", direction = Relationship.Direction.OUTGOING)
    private List<WorksAs> worksAs = new ArrayList<>();

    @Relationship(type = "KNOWS", direction = Relationship.Direction.OUTGOING)
    private List<Knows> knows = new ArrayList<>();

    @Relationship(type = "APPLIED_FOR", direction = Relationship.Direction.OUTGOING)
    private List<AppliedFor> appliedForJobs = new ArrayList<>();

    @Relationship(type = "INTERESTED_IN_SKILL", direction = Relationship.Direction.OUTGOING)
    private List<InterestedInSkill> interestedSkills = new ArrayList<>();

    @Relationship(type = "INTERESTED_IN_JOB", direction = Relationship.Direction.OUTGOING)
    private List<InterestedInJob> interestedJobs = new ArrayList<>();

    @Relationship(type = "INTERESTED_IN_COMPANY", direction = Relationship.Direction.OUTGOING)
    private List<InterestedInCompany> interestedCompanies = new ArrayList<>();

    public Person() {

    }

    public Person(long userId, String name, Long dob, String location, String currentPosition, int yearsOfExperience, List<String> education, List<String> interests) {
        this.userId = userId;
        this.name = name;
        this.dob = dob;
        this.location = location;
        this.currentPosition = currentPosition;
        this.yearsOfExperience = yearsOfExperience;
        this.education = education;
        this.interests = interests;
    }
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public List<InterestedInSkill> getInterestedSkills() {
        return interestedSkills;
    }

    public void setInterestedSkills(List<InterestedInSkill> interestedSkills) {
        this.interestedSkills = interestedSkills;
    }

    public List<InterestedInJob> getInterestedJobs() {
        return interestedJobs;
    }

    public void setInterestedJobs(List<InterestedInJob> interestedJobs) {
        this.interestedJobs = interestedJobs;
    }

    public List<InterestedInCompany> getInterestedCompanies() {
        return interestedCompanies;
    }

    public void setInterestedCompanies(List<InterestedInCompany> interestedCompanies) {
        this.interestedCompanies = interestedCompanies;
    }

    public List<AppliedFor> getAppliedForJobs() {
        return appliedForJobs;
    }

    public void setAppliedForJobs(List<AppliedFor> appliedForJobs) {
        this.appliedForJobs = appliedForJobs;
    }

    public List<Knows> getKnows() {
        return knows;
    }

    public void setKnows(List<Knows> knows) {
        this.knows = knows;
    }

    public List<WorksAs> getWorksAs() {
        return worksAs;
    }

    public void setWorksAs(List<WorksAs> worksAs) {
        this.worksAs = worksAs;
    }

    public List<WorksAt> getWorksAt() {
        return worksAt;
    }

    public void setWorksAt(List<WorksAt> worksAt) {
        this.worksAt = worksAt;
    }

    public void setSkills(List<SkillRelation> skills) {
        this.skills = skills;
    }

    public List<SkillRelation> getSkills() {
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

    public Long getDob() {
        return dob;
    }

    public void setDob(Long dob) {
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
