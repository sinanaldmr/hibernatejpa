package com.hibernatejpa.service;

import com.hibernatejpa.entityfactory.EntityFactory;
import com.hibernatejpa.entityfactory.impl.EntityFactoryImpl;
import com.hibernatejpa.model.Advertisement;

import java.util.List;

public interface AdvertisementService {
    boolean saveAdvertisement(Advertisement advertisement);
    boolean updateAdvertisement(Advertisement advertisement);
    boolean removeAdvertisement(Advertisement advertisement);
    Advertisement findById(Integer id);
    List<Advertisement> findByUsername(String username);
    List<Advertisement> findAdvertisements();
    List<Advertisement> findAdvertisementEntities(int firstResult,int maxResult);
}
