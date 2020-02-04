package com.srg.user.enums;

import lombok.Getter;

@Getter
public enum UserGrade {
    OWNER("OWNER", 1),
    ADMIN("ADMIN", 2),
    NORMAL("NORMAL", 3);

    private String value;
    private int priority;

    UserGrade(String value, int priority) {
        this.value = value;
        this.priority = priority;
    }
}
