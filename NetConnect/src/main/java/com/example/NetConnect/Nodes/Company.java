package com.example.NetConnect.Nodes;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.List;

@Node
public class Company {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String location;
    private long employeeCount;
    private String industryType;
    private String description;

    @Relationship(type = "POSTS" , direction = Relationship.Direction.OUTGOING)
    private List<Posts> jobPosts = new ArrayList<>();

    public Company(String name, String location, long employeeCount, String industryType, String description) {
        this.name = name;
        this.location = location;
        this.employeeCount = employeeCount;
        this.industryType = industryType;
        this.description = description;
    }

    public List<Posts> getJobPosts() {
        return jobPosts;
    }

    public void setJobPosts(List<Posts> jobPosts) {
        this.jobPosts = jobPosts;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public long getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(long employeeCount) {
        this.employeeCount = employeeCount;
    }

    public String getIndustryType() {
        return industryType;
    }

    public void setIndustryType(String industryType) {
        this.industryType = industryType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Company() {
    }

}
