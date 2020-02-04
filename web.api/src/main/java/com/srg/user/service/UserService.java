package com.srg.user.service;

import com.google.common.base.Strings;
import com.srg.user.entity.User;
import com.srg.user.enums.UserGrade;
import com.srg.user.model.UserRegisterRequest;
import com.srg.user.model.UserModifyRequest;
import com.srg.user.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Transactional
    public void registerUser(UserRegisterRequest request) {
        User user = new User(request);
        user.setUserGrade(UserGrade.NORMAL);
        user.setDeleted(false);
        userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public User getUserDetail(String userId) {
        return userRepository.findByUserId(userId);
    }

    @Transactional
    public void modifyUser(long userNo, UserModifyRequest request) {
        User user = userRepository.findByUserNo(userNo);
        if (!Strings.isNullOrEmpty(request.getPassword())) {
            user.setPassword(request.getPassword());
        }

        if (!Strings.isNullOrEmpty(request.getUserName())) {
            user.setUserName(request.getUserName());
        }

        if (!Strings.isNullOrEmpty(request.getMobileNo())) {
            user.setMobileNo(request.getMobileNo());
        }

        if (request.getUserType() != null) {
            user.setUserType(request.getUserType());
        }

        if (!Strings.isNullOrEmpty(request.getBirthday())) {
            user.setBirthday(request.getBirthday());
        }

        if (!Strings.isNullOrEmpty(request.getEmail())) {
            user.setEmail(request.getEmail());
        }

        if (!Strings.isNullOrEmpty(request.getAddress())) {
            user.setAddress(request.getAddress());
        }

        if (!Strings.isNullOrEmpty(request.getNickname())) {
            user.setNickname(request.getNickname());
        }
    }

    @Transactional
    public void deleteUser(long userNo) {
        User user = userRepository.findByUserNo(userNo);
        user.setDeleted(true);
    }

    public void login() {

    }

    public void logout() {

    }
}
