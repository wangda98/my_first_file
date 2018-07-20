package com.da.springbootdemo1.controller;

import com.da.springbootdemo1.bean.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class userController {
    @RequestMapping("/index")
    public String test(User user) {
         System.out.println("=="+user);
        return  "success";
    }
}
