package com.srg.enums;

import lombok.Getter;

@Getter
public enum RestaurantCategory {
    RC01("한식", 1),
    RC02("중식", 2),
    RC03("일식", 3),
    RC04("서양식", 4),
    RC05("육류", 5),
    RC06("해산물", 6),
    RC07("패스트푸드", 7),
    RC08("제과점", 8),
    RC09("기타", 9);

    private String value;
    private int priority;

    RestaurantCategory(String value, int priority) {
        this.value = value;
        this.priority = priority;
    }
}
