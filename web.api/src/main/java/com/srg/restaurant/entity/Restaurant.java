package com.srg.restaurant.entity;

import com.srg.restaurant.enums.RestaurantCategory;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "restaurant")
@Getter
@Setter
public class Restaurant {

    // TODO: 2020/02/05 빌드 오류(builder 관련)로 인해 임시로 @AllArgsConstructor 사용
    public Restaurant() {
    }

    // 음식점 번호
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rst_no", columnDefinition = "int(11) unsigned")
    private long rstNo;

    // 위치 정보
    @Column(name = "location_no", nullable = true, columnDefinition = "int(11) unsigned default 0")
    @ColumnDefault("0")
    private long locationNo;

    // 상호명
    @Column(name = "rst_name", nullable = false)
    @NotNull
    @Length(max = 100)
    private String rstName;

    // 음식 분류
    @Column(columnDefinition = "char(4)", nullable = true)
    @Enumerated(EnumType.STRING)
    private RestaurantCategory rstCategory;

    // 영업 시간
    @Column(name = "store_hour", nullable = false)
    @NotNull
    @Length(max = 100)
    private String storeHour;

    // 가게 메뉴
    @Column(name = "rst_menu", nullable = true, columnDefinition = "TEXT")
    private String rstMenu;

    // 가게 소개
    @Column(name = "rst_desc", nullable = true, columnDefinition = "TEXT")
    private String rstDesc;

    // 별점 (부동소수점 오차 회피 위해 정수 타입 사용)
    @NotNull
    @Column(nullable = true, columnDefinition = "int(11) unsigned")
    private int score = 0;

    // 해시 태그 (검색어)
    @Column(name = "rst_tag", nullable = false)
    @NotNull
    @Length(max = 200)
    private String rstTag;

    // 등록일
    @NotNull
    private LocalDateTime regYmdt = LocalDateTime.now();

    // 수정일
    @NotNull
    private LocalDateTime lastUpdateYmdt = LocalDateTime.now();


}
