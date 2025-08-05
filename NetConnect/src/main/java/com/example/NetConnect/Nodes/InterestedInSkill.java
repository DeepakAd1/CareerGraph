package com.example.NetConnect.Nodes;

import org.springframework.data.neo4j.core.schema.RelationshipProperties;

@RelationshipProperties
public class InterestedInSkill extends BaseInterestRelation<Skill> {
    // You can add more properties specific to Skill interest if needed
}

