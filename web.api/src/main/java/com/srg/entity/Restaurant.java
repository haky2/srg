package com.srg.entity;

import com.srg.enums.RestaurantCategory;
import lombok.Builder;
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
@Builder
public class Restaurant {

    private Restaurant() {
    }

    // 음식점 번호
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rst_no", columnDefinition = "int(11) unsigned")
    private int rstNo;

    // 위치 정보
    @Column(name = "location_no", nullable = true, columnDefinition = "int(11) unsigned")
    @ColumnDefault("0")
    private Integer locationNo;

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
