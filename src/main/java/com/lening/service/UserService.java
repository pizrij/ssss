package com.lening.service;

import com.lening.entity.User;
import com.lening.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface UserService {


    List<User> findAll();

    User getUserById(long id);

    List<User> getUserByIdAndAge(Long id, Integer age);
}
