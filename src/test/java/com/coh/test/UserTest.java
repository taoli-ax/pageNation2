package com.coh.test;

import com.coh.pojo.User;
import com.coh.service.BirdService;
import com.coh.service.CarService;
import com.coh.service.ChargeService;
import com.coh.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
    public void testCarService(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        CarService carService=(CarService)applicationContext.getBean("carService");
        carService.show();


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
    public void testAnnotationChargeService(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("app2.xml");
        ChargeService chargeService=(ChargeService)applicationContext.getBean("chargeService");
        chargeService.doCharge();

    }
    @Test
    public void testAnnotationAopChargeService(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("app3.xml");
        ChargeService chargeService=(ChargeService)applicationContext.getBean("chargeService");
        chargeService.doCharge();

    }

    
}
