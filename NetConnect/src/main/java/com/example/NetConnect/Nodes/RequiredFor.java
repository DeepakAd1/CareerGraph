package com.example.NetConnect.Nodes;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

@RelationshipProperties
public class RequiredFor {

    @Id
    @GeneratedValue
    private Long id;

    private Double matchScore;

    @TargetNode
    private Job job;

    public RequiredFor(Double matchScore, Job job) {
        this.matchScore = matchScore;
        this.job = job;
    }

    public RequiredFor() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getMatchScore() {
        return matchScore;
    }

    public void setMatchScore(Double matchScore) {
        this.matchScore = matchScore;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }
}
