package com.example.NetConnect.repository;

import com.example.NetConnect.Nodes.Company;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface CompanyRepo extends Neo4jRepository<Company,Long> {
}
