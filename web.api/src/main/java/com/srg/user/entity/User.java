package com.srg.user.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.srg.user.enums.UserGrade;
import com.srg.user.enums.UserType;
import com.srg.user.model.UserRegisterRequest;

import org.hibernate.annotations.Type;
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
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
public class User {

    // 회원번호
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_no")
    private long userNo;

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

    // 삭제여부
    @Type(type = "yes_no")
    @Column(name = "deleted_yn")
    private boolean deleted;

    // 가입시각
    @NotNull
    private LocalDateTime joinYmdt = LocalDateTime.now();

    // 최근 접속시각
    private LocalDateTime lastLoginYmdt;

    // 접속횟수
    private Integer loginCount = 0;

    // 최종 등급 수정일
    private LocalDateTime lastGradeUpdateYmdt;

    public User(UserRegisterRequest request) {
        this.userId = request.getUserId();
        this.userGrade = UserGrade.NORMAL;
        this.userName = request.getUserName();
        this.mobileNo = request.getMobileNo();
        this.userType = UserType.NORMAL;
        this.birthday = request.getBirthday();
        this.sex = request.getSex();
        this.email = request.getEmail();
        this.address = request.getAddress();
        this.nickname = request.getNickname();
        this.deleted = false;
    }
}
