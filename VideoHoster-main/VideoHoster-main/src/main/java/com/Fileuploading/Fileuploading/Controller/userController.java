package com.Fileuploading.Fileuploading.Controller;


import com.Fileuploading.Fileuploading.Modle.User;
import com.Fileuploading.Fileuploading.Repository.UserRepo;
import com.Fileuploading.Fileuploading.Service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
public class userController {

    @Autowired
    public UserService userService;

    @PostMapping("/user/signin")
    private String createuser(@RequestBody String data) throws JsonProcessingException {
        User user=new ObjectMapper().readValue(data,User.class);
        System.out.println(user.toString());
        String res=userService.createuser(user);
        if(res.equals("false"))
        {
            return "false";
        }
        else
        {
            return res;
        }

    }



    @PostMapping("/user/login")
    private String checkuser(@RequestBody String data) throws JsonProcessingException {
        User user=new ObjectMapper().readValue(data,User.class);
        System.out.println(user.toString());
        String id=userService.checkuser(user);
        if(id.equals("false"))
        {
            return "false";
        }
        else
        {
            return id;
        }
    }


}
