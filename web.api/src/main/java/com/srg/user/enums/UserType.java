package com.srg.user.enums;

import lombok.Getter;

@Getter
public enum UserType {
    NORMAL("NORMAL", 1),
    NAVER("NAVER", 2),
    KAKAO("KAKAO", 3),
    PAYCO("PAYCO", 4);

    private String value;
    private int priority;

    UserType(String value, int priority) {
        this.value = value;
        this.priority = priority;
    }
}
