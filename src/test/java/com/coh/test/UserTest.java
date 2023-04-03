package com.coh.test;

import com.coh.pojo.Cup;
import com.coh.service.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class UserTest {
    @Test
    public void testUserService(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService=(UserService)applicationContext.getBean("userService");
        System.out.println(userService.getUser());

}
    @Test
    public void testBirdService(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        BirdService birdService=(BirdService)applicationContext.getBean("birdService");
        System.out.println(birdService.getStrings());
        System.out.println(birdService.getMaps());


    }
    @Test
    public void testBirdService2(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        BirdService birdService=(BirdService)applicationContext.getBean("birdService");
        System.out.println(birdService);
        // TODO: 2023/3/30   构造注入没完成

    }

    @Test
    public void testErrorCarService(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("app.xml");
        CarService carService=(CarService)applicationContext.getBean("carService");
        carService.show();


    }
    @Test
    public void testAroundCarService(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("app.xml");
        CarService carService=(CarService)applicationContext.getBean("carService");
        carService.findAll();

    }
    @Test
    public void testCase1(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("app4.xml");
        CupService cupService=(CupService)applicationContext.getBean("cupServiceImpl");
        List<Cup> cupList=cupService.queryCupByName();
        System.out.println(cupList);
    }





    
}
