package com.geekster.User_Managment_System;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
public class ApiCalling {
    @Autowired
    List<User> userList;

    //adduser
    @PostMapping("api/user")
    public String addUser(@RequestBody User user){
        userList.add(user);
        return "User added";
    }

    //getUser/userid
    // User Doubt
    @GetMapping("api/user/{id}/detail")
    public User getUser(@PathVariable Integer id)
    {
        for(User user : userList){
            if(user.getUserId().equals(id))
            {
             return user;
            }
        }
        return null;
    }

    //getAllUser
    @GetMapping("all/user")
    public List<User> allUserList()
    {
        return userList;
    }

    //update userinfo
    @PutMapping("api/user/{id}/number/")
    public String updateUserInfo(@PathVariable Integer id, @RequestBody User updateUser)
    {
        for(User user : userList){
            if(user.getUserId().equals(id))
            {
                user.setUserId(updateUser.getUserId());
                user.setName(updateUser.getName());
                user.setPhoneNumber(updateUser.getPhoneNumber());
                return "updated"+" "+id;
            }
        }
        return "Invalid Id";
    }

    //delete user
    @DeleteMapping("api/user/{id}/id")
    public String deleteUser(@PathVariable Integer id)
    {
        for(User user : userList)
        {
            if(user.getUserId().equals(id)){
                userList.remove(user);
                return "remove" +" "+id;
            }
        }
        return "Invalid Id";
    }
}
