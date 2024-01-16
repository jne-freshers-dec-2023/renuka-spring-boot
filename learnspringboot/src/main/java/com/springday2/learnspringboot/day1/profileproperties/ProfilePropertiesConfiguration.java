package com.springday2.learnspringboot.day1.profileproperties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "profileproperties")
public class ProfilePropertiesConfiguration {
    @Value("${profileproperties.url}")
    public static   String url;
    private  String username;
    private String key;
    public String getUrl() {
        System.out.println(url);
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }
}
