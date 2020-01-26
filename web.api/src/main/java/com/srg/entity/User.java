package com.srg.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.srg.enums.UserGrade;
import com.srg.enums.UserType;

import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter
@Setter
public class User {

    // 회원번호
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_no")
    private int userNo;

    // 회원아이디
    @NotNull
    private String userId;

    // 회원등급
    @Enumerated(EnumType.STRING)
    @NotNull
    private UserGrade userGrade;

    // 비밀번호
    @JsonIgnore
    private String password;

    // 회원명
    @Column(name = "name", nullable = false)
    @NotNull
    @Length(max = 255)
    private String userName;

    // 휴대폰번호
    @Column(name = "mobile_no", columnDefinition = "varchar(11)", nullable = false)
    private String mobileNo;

    // 회원유형
    @Enumerated(EnumType.STRING)
    @NotNull
    private UserType userType;

    // 생년월일
    @Column(columnDefinition = "varchar(10)")
    private String birthday;

    // 성별
    @Column(columnDefinition = "char(1)")
    private String sex;

    // 이메일
    @NotNull
    private String email;

    // 주소
    private String address;

    // 닉네임
    private String nickname;

    // 가입시각
    @NotNull
    private LocalDateTime joinYmdt = LocalDateTime.now();

    // 최근 접속시각
    private LocalDateTime lastLoginYmdt;

    // 접속횟수
    private Integer loginCount = 0;

    // 최종 등급 수정일
    private LocalDateTime lastGradeUpdateYmdt;

}
