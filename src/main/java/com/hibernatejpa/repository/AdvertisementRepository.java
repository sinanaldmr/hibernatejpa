package com.hibernatejpa.repository;

import com.hibernatejpa.entityfactory.EntityFactory;
import com.hibernatejpa.entityfactory.impl.EntityFactoryImpl;
import com.hibernatejpa.model.Advertisement;

import javax.swing.text.html.parser.Entity;
import java.util.List;

public interface AdvertisementRepository {
    EntityFactory entityFactory=new EntityFactoryImpl();
    boolean saveAdvertisement(Advertisement advertisement);
    boolean updateAdvertisement(Advertisement advertisement);
    boolean removeAdvertisement(Advertisement advertisement);
    Advertisement findById(Integer id);
    List<Advertisement> findByUsername(String username);
    List<Advertisement> findAdvertisements();
    List<Advertisement> findAdvertisementEntities(int firstResult,int maxResult);
}
