package com.hibernatejpa.service.impl;

import com.hibernatejpa.model.UserDetail;
import com.hibernatejpa.repository.UserDetailRepository;
import com.hibernatejpa.repository.impl.UserDetailRepositoryImpl;
import com.hibernatejpa.service.UserDetailService;

public class UserDetailServiceImpl implements UserDetailService {
    UserDetailRepository userDetailRepository=new UserDetailRepositoryImpl();

    @Override
    public boolean saveUserDetail(UserDetail userDetail) {
        return this.userDetailRepository.saveUserDetail(userDetail);
    }

    @Override
    public boolean updateUserDetail(UserDetail userDetail) {
        return this.userDetailRepository.updateUserDetail(userDetail);
    }

    @Override
    public boolean removeUserDetail(UserDetail userDetail) {
        return this.userDetailRepository.removeUserDetail(userDetail);
    }

    @Override
    public UserDetail findById(Integer id) {
        return this.userDetailRepository.findById(id);
    }

    @Override
    public UserDetail findByUserName(String username) {
        return this.userDetailRepository.findByUserName(username);
    }

    @Override
    public UserDetail findWithAddressByUsername(String username) {
        return this.userDetailRepository.findWithAddressByUsername(username);
    }

    @Override
    public UserDetail findWithAdvertisementByUsername(String username) {
        return this.userDetailRepository.findWithAdvertisementByUsername(username);
    }
}
