package com.arjuncodes.studentsystem.Enums.JobEnums;

public enum JobEnums {

    ACCEPTED("accepted"),
    DECLINE("decline"),
    HISTORY("history");

    private final String name;

    JobEnums(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
