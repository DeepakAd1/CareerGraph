package com.example.NetConnect.Nodes;

import org.springframework.data.neo4j.core.schema.TargetNode;

public abstract class BaseInterestRelation<T> {

    private int interestLevel;
    private String since;

    @TargetNode
    private T target;

    public int getInterestLevel() {
        return interestLevel;
    }

    public void setInterestLevel(int interestLevel) {
        this.interestLevel = interestLevel;
    }

    public String getSince() {
        return since;
    }

    public void setSince(String since) {
        this.since = since;
    }

    public T getTarget() {
        return target;
    }

    public void setTarget(T target) {
        this.target = target;
    }
}
