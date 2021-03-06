package com.hibernatejpa.service;

import com.hibernatejpa.entityfactory.EntityFactory;
import com.hibernatejpa.entityfactory.impl.EntityFactoryImpl;
import com.hibernatejpa.model.UserDetail;

public interface UserDetailService {
    boolean saveUserDetail(UserDetail userDetail);
    boolean updateUserDetail(UserDetail userDetail);
    boolean removeUserDetail(UserDetail userDetail);
    UserDetail findById(Integer id);
    UserDetail findByUserName(String username);
    UserDetail findWithAddressByUsername(String username);
    UserDetail findWithAdvertisementByUsername(String username);
}
