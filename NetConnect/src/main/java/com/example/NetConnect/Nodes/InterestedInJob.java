package com.example.NetConnect.Nodes;

import org.springframework.data.neo4j.core.schema.RelationshipProperties;

@RelationshipProperties
public class InterestedInJob extends BaseInterestRelation<Job> {
    // Add job-specific interest properties if required
}

