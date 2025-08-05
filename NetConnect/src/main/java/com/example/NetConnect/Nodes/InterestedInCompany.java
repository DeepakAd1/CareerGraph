package com.example.NetConnect.Nodes;

import org.springframework.data.neo4j.core.schema.RelationshipProperties;

@RelationshipProperties
public class InterestedInCompany extends BaseInterestRelation<Company> {
    // Add company-specific interest properties if required
}

