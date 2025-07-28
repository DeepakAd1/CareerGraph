package com.example.NetConnect.repository;

import com.example.NetConnect.Nodes.Skill;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepo extends Neo4jRepository<Skill,Long> {
}
