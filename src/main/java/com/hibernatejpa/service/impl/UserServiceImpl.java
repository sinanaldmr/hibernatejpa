package com.hibernatejpa.service.impl;

import com.hibernatejpa.model.User;
import com.hibernatejpa.model.UserInfo;
import com.hibernatejpa.repository.UserRepository;
import com.hibernatejpa.repository.impl.UserRepositoryImpl;
import com.hibernatejpa.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserRepository userRepository=new UserRepositoryImpl();

    @Override
    public boolean saveUser(User user) {
        return this.userRepository.saveUser(user);
    }

    @Override
    public boolean updateUser(User user) {
        return this.userRepository.updateUser(user);
    }

    @Override
    public boolean removeUser(User user) {
        return this.userRepository.removeUser(user);
    }

    @Override
    public User findById(Integer id) {
        return this.userRepository.findById(id);
    }

    @Override
    public User findByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public User findWithUserDetailByUsername(String username) {
        return this.userRepository.findWithUserDetailByUsername(username);
    }

    @Override
    public List<User> findUsers() {
        return this.userRepository.findUsers();
    }

    @Override
    public List<User> findUsers(int firstResult, int maxResult) {
        return this.userRepository.findUsers(firstResult,maxResult);
    }

    @Override
    public int findUserCount() {
        return this.userRepository.findUserCount();
    }

    @Override
    public UserInfo findUserInfoByUsername(String username) {
        return this.userRepository.findUserInfoByUsername(username);
    }
}
