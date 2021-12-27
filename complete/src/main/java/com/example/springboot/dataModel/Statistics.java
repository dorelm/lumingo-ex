package com.example.springboot.dataModel;

public class Statistics {
    int active_instances;
    Long total_invocation;

    public Statistics(int active_instances, Long total_invocation) {
        this.active_instances = active_instances;
        this.total_invocation = total_invocation;
    }
}
