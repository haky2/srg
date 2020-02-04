package com.srg.user.model;

import com.srg.user.enums.UserType;

import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserModifyRequest {

    // 비밀번호
    @NotNull
    private String password;

    // 회원명
    @NotNull
    private String userName;

    // 휴대폰번호
    @NotNull
    private String mobileNo;

    // 회원유형
    @NotNull
    private UserType userType;

    // 생년월일
    private String birthday;

    // 이메일
    @NotNull
    private String email;

    // 주소
    private String address;

    // 닉네임
    private String nickname;
}
