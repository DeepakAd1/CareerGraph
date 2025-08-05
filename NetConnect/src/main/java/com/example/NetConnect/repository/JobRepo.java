package com.example.NetConnect.repository;

import com.example.NetConnect.Nodes.Job;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface JobRepo extends Neo4jRepository<Job,Long> {
}
