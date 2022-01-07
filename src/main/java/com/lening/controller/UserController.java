package com.lening.controller;

import com.lening.entity.User;
import com.lening.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("/findAll")
    public List<User> findAll(){
        return userService.findAll();
    }

    /**
     * 这是restful的写法
     * 把参数，传到路径后面，然后再参数前面加一个注解PathVariable
     * user/getUserById/2
     */
    @GetMapping("/getUserById/{id}")
    public User queryById(@PathVariable("id") Long id) {
        return userService.getUserById(id);
    }
    @GetMapping("/getByIdAndAge/{age}")
    public List<User> queryByIdAndAge(@PathVariable("age")Integer age) {
        return userService.getUserByIdAndAge(null,age);
    }
}
