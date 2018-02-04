package com.bxw.ioc;

/**
 * 用户Service实现
 * 使用@Component，使其受容器管理
 *
 * Created by wxb on 2018/2/4.
 */
@Component
public class UserService {
    public User getUser(){
        User user = new User("wxb", 23);
        return user;
    }
}
