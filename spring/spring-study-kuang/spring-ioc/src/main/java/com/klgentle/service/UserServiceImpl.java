package com.klgentle.service;

import com.klgentle.dao.UserDao;
import com.klgentle.dao.UserDaoImpl;

public class UserServiceImpl implements UserService {
    //程序猿手动创建dao层对象,用来调用dao层方法
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void getUser() {
        userDao.getUser();
    }
}
