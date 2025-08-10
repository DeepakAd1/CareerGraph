package com.example.NetConnect.Nodes;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.List;

@Data
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

    public void setJobPosts(List<Posts> jobPosts) {
        this.jobPosts = jobPosts;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setEmployeeCount(long employeeCount) {
        this.employeeCount = employeeCount;
    }

    public void setIndustryType(String industryType) {
        this.industryType = industryType;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Company() {
    }

}
