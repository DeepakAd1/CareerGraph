package com.example.NetConnect.repository;

import com.example.NetConnect.Nodes.Person;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepo extends Neo4jRepository<Person,Long> {

}
