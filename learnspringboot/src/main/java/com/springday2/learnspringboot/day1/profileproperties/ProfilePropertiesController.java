package com.springday2.learnspringboot.day1.profileproperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfilePropertiesController {
    @Autowired
    ProfilePropertiesConfiguration profileproperties;
    @RequestMapping("/profileproperties")
    public ProfilePropertiesConfiguration  retriveProperties(){
        return profileproperties;
    }

}
