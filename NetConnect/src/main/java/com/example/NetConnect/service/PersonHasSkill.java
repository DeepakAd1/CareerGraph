package com.example.NetConnect.service;

import com.example.NetConnect.Nodes.Person;
import com.example.NetConnect.Nodes.Skill;
import com.example.NetConnect.Nodes.SkillRelation;
import com.example.NetConnect.repository.PersonRepo;
import com.example.NetConnect.repository.SkillRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonHasSkill {

    @Autowired
    private PersonRepo personRepo;

    @Autowired
    private SkillRepo skillRepo;

    public void savePersonHasSkill(){
        Person p = new Person("deepak","02-12-2003","Erode","SDE",0, List.of("BE-CSE"),List.of("footbal,java,basketball"));
        Skill s = new Skill("Java","NPTEL","Intermediate",1);
        try{
            skillRepo.save(s);
        }catch (Exception e){
            System.out.println("Error in saving skill : "+e);
        }
        SkillRelation skillRelation = new SkillRelation(1,s);
        p.setSkills(List.of(skillRelation));
        try{
            personRepo.save(p);
        }catch(Exception e){
            System.out.print("Error in saving the person with skillRelation : "+e);
        }
    }
}
