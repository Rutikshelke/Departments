package com.dailycodebuffer.springboot.tutorial.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
   // @RequestMapping(value = "/",method = RequestMethod.GET)
    @GetMapping("/")
    public String HelloWorld(){
        return "welcome to daily code buffer sunny leone is not only actor" ;
    }

    @GetMapping("/hello")
    public String sayHello(){
        return "hello user!";
    }
}
