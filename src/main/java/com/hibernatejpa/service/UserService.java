package com.hibernatejpa.service;

import com.hibernatejpa.entityfactory.EntityFactory;
import com.hibernatejpa.entityfactory.impl.EntityFactoryImpl;
import com.hibernatejpa.model.User;
import com.hibernatejpa.model.UserInfo;

import java.util.List;

public interface UserService {
    boolean saveUser(User user);
    boolean updateUser(User user);
    boolean removeUser(User user);
    User findById(Integer id);
    User findByUsername(String username);
    User findWithUserDetailByUsername(String username);
    List<User> findUsers();
    List<User> findUsers(int firstResult, int maxResult);
    int findUserCount();
    UserInfo findUserInfoByUsername(String username);
}
