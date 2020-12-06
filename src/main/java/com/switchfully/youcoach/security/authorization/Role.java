package com.switchfully.skeleton.security.authorization;

public enum Role {
    STUDENT("student"),
    COACH("coach");

    private String label;

    Role(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
