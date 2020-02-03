package com.srg.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "RestaurantPosition")
@Getter
@Setter
public class RestaurantPosition {

    // 맛집 고유 번호
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rst_name")
    private long rstNo;

    // 맛집 좌표
    @Column(name = "res_coordinate", nullable = false)
    @NotNull
    @Length(max = 255)
    private String resCoordinate;

    // 맛집 주소
    @Column(name = "res_address", nullable = false)
    @NotNull
    @Length(max = 255)
    private String resAddress;


    // 등록 시간
    @NotNull
    private LocalDateTime regiYmdt = LocalDateTime.now();

    // 수정 시간
    private LocalDateTime updateYmdt;
}
