package com.klgentle.demo2;

public class Client {
    public static void main(String[] args) {
        UserServiceImp userService = new UserServiceImp();
        //userService.add();
        UserServiceProxy proxy = new UserServiceProxy();
        proxy.setUserService(userService);
        proxy.query();
    }
}
