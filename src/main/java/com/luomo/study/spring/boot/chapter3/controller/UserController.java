package com.luomo.study.spring.boot.chapter3.controller;

import com.luomo.study.spring.boot.chapter3.domain.User;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by LiuMei on 2017-09-19.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    // 创建线程安全的Map
    static Map<Long,User> users = Collections.synchronizedMap(new HashMap<Long,User>());

    @RequestMapping(method = RequestMethod.GET)
    public List<User> getUserList(){
        List<User> data = new ArrayList<>(users.values());
        return data;
    }

    @RequestMapping(method=RequestMethod.POST)
    public String postUser(@ModelAttribute User user) {
        users.put(user.getId(), user);
        return "success";
    }

    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public User getUser(@PathVariable Long id) {
        return users.get(id);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public String putUser(@PathVariable Long id, @ModelAttribute User user) {
        User u = users.get(id);
        u.setName(user.getName());
        u.setAge(user.getAge());
        users.put(id, u);
        return "success";
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id) {
        users.remove(id);
        return "success";
    }

}
