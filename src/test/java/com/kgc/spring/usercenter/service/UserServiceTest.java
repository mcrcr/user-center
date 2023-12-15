package com.kgc.spring.usercenter.service;
import java.util.Date;

import com.kgc.spring.usercenter.model.domain.User;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author 马昌瑞
 * @version 1.0
 */

@SpringBootTest
class UserServiceTest {

    @Resource
    private UserService userService;
    @Test
    void testAddUser(){
        User user = new User();
        user.setUsername("dogyipi");
        user.setUserAccount("123");
        user.setAvatarUrl("https://pics0.baidu.com/feed/54fbb2fb43166d22a7fd5722db5f35fa9152d20c.jpeg?token=3f50f1fe09e9c4e82bd1f8ef17acba2b");
        user.setGender(0);
        user.setUserPassword("xxxx");
        user.setPhone("123");
        user.setEmail("12341");
        user.setUserStatus(1);
        user.setCreatetime(new Date());
        user.setUpdatetime(new Date());
        user.setIsDelete(0);
        user.setUserRole(0);
        user.setPlanetCode("");
        user.setTags("");


        boolean save = userService.save(user);
        System.out.println(user.getId());
        Assertions.assertEquals(true,save);
    }


    @Test
    void userRegister(){
        String  userAccount = "yupi";
        String userPassword = "";
        String checkPassword="123456";
        long result = userService.userRegister(userAccount,userPassword,checkPassword);
        Assertions.assertEquals(-1,result);
        userPassword="yu";
        result = userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1,result);
        userAccount = "yupi";
        userPassword = "123456";
        result = userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1,result);
        userAccount = "yu pi";
        userPassword = "12345678";
        result = userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1,result);
        checkPassword="123456789";
        result = userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1,result);
        userAccount = "dogyupi";
        checkPassword = "12345678";
        result = userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1,result);
        userAccount= "yupi";
        result = userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1,result);
    }
}