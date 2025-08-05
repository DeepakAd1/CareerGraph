package com.example.NetConnect.Nodes;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

import java.sql.Date;

@RelationshipProperties
public class AppliedFor {

    @Id
    @GeneratedValue
    private Long id;

    private Date appliedDate;
    private String status;  // pending, interview, offered, rejected

    @TargetNode
    private Job job;

    public AppliedFor() {}

    public AppliedFor(Date appliedDate, String status, Job job) {
        this.appliedDate = appliedDate;
        this.status = status;
        this.job = job;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getAppliedDate() {
        return appliedDate;
    }

    public void setAppliedDate(Date appliedDate) {
        this.appliedDate = appliedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }
}

