package com.srg.user.controller;

import com.srg.user.model.UserModifyRequest;
import com.srg.user.model.UserRegisterRequest;
import com.srg.user.service.UserService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import static org.springframework.http.ResponseEntity.noContent;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
@Slf4j
public class UserRestController {

    UserService userService;

    @PostMapping
    public ResponseEntity<?> registerUser(@RequestBody UserRegisterRequest request) {
        log.debug("register user : " + request);
        userService.registerUser(request);
        return noContent().build();
    }

    @GetMapping("{userNo}")
    public ResponseEntity<?> getUser(@PathVariable("userNo") String userId) {
        return ok(userService.getUserDetail(userId));
    }

    @PutMapping("{userNo}")
    public ResponseEntity<?> modifyUser(@PathVariable("userNo") long userNo, @RequestBody UserModifyRequest request) {
        userService.modifyUser(userNo, request);
        return noContent().build();
    }

    @DeleteMapping("{userNo}")
    public ResponseEntity<?> deleteUser(@PathVariable("userNo") long userNo) {
        log.debug("delete user");
        userService.deleteUser(userNo);
        userService.logout();
        return noContent().build();
    }
}
