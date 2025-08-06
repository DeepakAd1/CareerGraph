package com.example.NetConnect.Nodes;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;

@RelationshipProperties
public class InterestedInJob extends BaseInterestRelation<Job> {
    // Add job-specific interest properties if required
    @Id
    @GeneratedValue
    private Long id;

    // Add company-specific interest properties if required

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

