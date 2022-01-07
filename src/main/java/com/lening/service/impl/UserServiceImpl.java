package com.lening.service.impl;

import com.lening.entity.User;
import com.lening.mapper.UserMapper;
import com.lening.service.UserService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.selectByExample(null);
    }

    @Override
    public User getUserById(long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<User> getUserByIdAndAge(Long id, Integer age) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        if(age!=null){
            criteria.andEqualTo("age", age);
        }
        return userMapper.selectByExample(example);
    }
}
