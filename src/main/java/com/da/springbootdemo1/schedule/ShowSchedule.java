package com.da.springbootdemo1.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ShowSchedule {
    @Scheduled(fixedRate = 1000)
    public  void  show(){
        System.out.println("......."+new Date().getSeconds());
    }
}
