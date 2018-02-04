package com.bxw.ioc;

/**
 * 用户Controller实现
 * 类用@Component注释，受容器管理
 * userService使用@Inject注释，表示该属性是容器自动注入该实例
 *
 * Created by wxb on 2018/2/4.
 */
@Component
public class UserController {
    @Inject
    private UserService userService;

    public void getUser(){
        User user = userService.getUser();
        System.out.println(user);
    }

}
