package com.srg.restaurant.model.request;

import com.srg.restaurant.enums.RestaurantCategory;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
public class RestaurantRegister {

    // 고유번호
    private Long rstNo;

    // 주소 고유 번호
    private Long locationNo;
    // 상호명
    @NotEmpty(message = "상호명을 입력해주세요.")
    @Size(max = 100, message = "상호명은 100자 이내로 입력해주세요.")
    private String rstName;

    // 음식 분류
    private RestaurantCategory rstCategory;

    // 영업 시간
    @NotEmpty(message = "영업 시간을 입력해주세요.")
    @Size(max = 100, message = "영업 시간은 100자 이내로 입력해주세요.")
    private String storeHour;

    // 가게 메뉴
    private String rstMenu;

    // 가게 소개
    private String rstDesc;

    // 별점 (부동소수점 오차 회피 위해 정수 타입 사용)
    private int score = 0;

    // 해시 태그 (검색어)
    @NotNull(message = "검색어(태그)를 입력해주세요.")
    @Size(max = 200, message = "검색어(태그)는 200자 이내로 입력해주세요.")
    private String rstTag;

    // 등록일
    private LocalDateTime regYmdt;

    // 수정일
    private LocalDateTime lastUpdateYmdt;

}
