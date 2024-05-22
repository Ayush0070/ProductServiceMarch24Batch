package com.example.firstspringapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sample")
public class SampleController {
    @GetMapping("/hello/{name}")
    public String hello(@PathVariable("name") String name){
        return "Hello and welcome!" + name + "!";
    }
    @GetMapping("/bye")
    public String sayBye(){
        return "Goodbye!";
    }
}
