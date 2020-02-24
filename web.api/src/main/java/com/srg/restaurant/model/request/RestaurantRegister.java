package com.srg.restaurant.model.request;

import com.srg.restaurant.enums.RestaurantCategory;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
public class RestaurantRegister {

    // 상호명
    @NotBlank
    @Size(max = 100)
    private String rstName;

    // 음식 분류
    private RestaurantCategory rstCategory;

    // 영업 시간
    @NotBlank
    @Size(max = 100)
    private String storeHour;

    // 가게 메뉴
    private String rstMenu;

    // 별점 (부동소수점 오차 회피 위해 정수 타입 사용)
    private int score = 0;

    // 해시 태그 (검색어)
    @NotBlank
    @Size(max = 200)
    private String rstTag;

    // 등록일
    private LocalDateTime regYmdt;

    // 수정일
    private LocalDateTime lastUpdateYmdt;

}
