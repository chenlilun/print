package com.example.print;

import com.example.print.bean.User;
import com.example.print.mapper.UserMapper;
import com.sun.tools.javac.util.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
//@ComponentScan(basePackages = "com.example.print")
public class PrintApplicationTests {
    @Resource
    private UserMapper userMapper;
    @Test
    void contextLoads() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
//        Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }


}
