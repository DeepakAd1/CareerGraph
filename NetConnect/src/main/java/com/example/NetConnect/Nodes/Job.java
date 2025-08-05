package com.example.NetConnect.Nodes;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import java.sql.Date;

@Node
public class Job {

    @Id
    @GeneratedValue
    private long id;
    private String title;
    private String description;
    private String requiredQualifications;
    private String workStyle;
    private String salaryRange;
    private Date postedDate;
}
