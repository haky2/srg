package com.srg.restaurant.enums;

import lombok.Getter;

@Getter
public enum RestaurantCategory {
    RC01("한식"),
    RC02("중식"),
    RC03("일식"),
    RC04("서양식"),
    RC05("육류"),
    RC06("해산물"),
    RC07("패스트푸드"),
    RC08("제과점"),
    RC09("기타");

    private String value;

    RestaurantCategory(String value) {
        this.value = value;
    }
}
