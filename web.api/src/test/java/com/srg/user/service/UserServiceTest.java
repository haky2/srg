package com.srg.user.service;

import com.srg.user.entity.User;
import com.srg.user.enums.UserType;
import com.srg.user.model.UserModifyRequest;
import com.srg.user.model.UserRegisterRequest;
import com.srg.user.repository.UserRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Test
    public void 등록테스트() {
        UserRegisterRequest request = UserRegisterRequest.builder()
                                                         .address("구로")
                                                         .birthday("1919-01-01")
                                                         .email("test@test.com")
                                                         .mobileNo("01012341234")
                                                         .nickname("test")
                                                         .sex("M")
                                                         .password("qwert12345")
                                                         .userId("test")
                                                         .userName("ttt")
                                                         .userType(UserType.NOMAL)
                                                         .build();

        userService.registerUser(request);

        User user = userRepository.findByUserId("test");

        assertEquals("주소", "구로", user.getAddress());
        assertEquals("생일", "1919-01-01", user.getBirthday());
        assertEquals("타입", UserType.NOMAL, user.getUserType());
    }

    @Test
    public void 업뎃테스트() {
        this.등록테스트();

        User user = userRepository.findByUserId("test");

        UserModifyRequest request = UserModifyRequest.builder()
                                                     .nickname("ccccc")
                                                     .build();

        userService.modifyUser(user.getUserNo(), request);

        User modify = userRepository.findByUserId("test");

        assertEquals("닉넴", "ccccc", modify.getNickname());
    }

    @Test
    public void 삭제테스트() {

        this.등록테스트();

        User user = userRepository.findByUserId("test");

        System.out.println(user.getUserNo());

        userService.deleteUser(user.getUserNo());

        User deleted = userRepository.findByUserId("test");

        assertTrue("삭제", deleted.isDeleted());
    }
}