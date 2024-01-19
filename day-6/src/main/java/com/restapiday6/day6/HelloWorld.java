package com.restapiday6.day6;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorld {
    @RequestMapping(method = RequestMethod.GET, path = "/hello-world")
    public String Hello(){
        return "Hello World!!";
    }

    @RequestMapping(method = RequestMethod.GET,path = "/hello-world-bean")
    public  HelloWorldJSON helloworld(){
        return  new HelloWorldJSON("hello world");
    }

    @GetMapping(path = "/hello-world-bean/path-variable/{name}")
    public HelloWorldJSON helloworld(@PathVariable String name){
        return  new HelloWorldJSON(String.format(" hello world " + name ));
    }
}
