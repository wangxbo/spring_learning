package com.bxw.ioc;

/**
 * 模拟调用UserController
 *
 * 结果 ： User{userName='wxb', age=23}
 *
 * Created by wxb on 2018/2/4.
 */
public class Main {
    public static void main(String[] args) {
        UserController userController = (UserController) IocContext.applicationContext.get(UserController.class);
        userController.getUser();
    }
}
