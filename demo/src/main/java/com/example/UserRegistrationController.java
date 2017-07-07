package com.example;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class UserRegistrationController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> getHome() {

        Map<String, String> response = new HashMap<String, String>();
        try {
            RegisteredUser user = new RegisteredUser();
            user.setFirstName("Hassan");
            user.setLastName("Bokhari");
            user.setCreateTime(new Date());
            
            userService.create(user);
            
            response.put("status", "success");
        } catch (Exception e) {
            response.put("status", "fail");
        }

        return response;
    }
}