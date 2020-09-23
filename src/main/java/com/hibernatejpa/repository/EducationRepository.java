package com.hibernatejpa.repository;

import com.hibernatejpa.entityfactory.EntityFactory;
import com.hibernatejpa.entityfactory.impl.EntityFactoryImpl;
import com.hibernatejpa.model.Education;

import java.util.List;

public interface EducationRepository {
    EntityFactory entityFactory=new EntityFactoryImpl();
    boolean saveEducation(Education education);
    boolean updateEducation(Education education);
    boolean removeEducation(Education education);
    Education findById(Integer id);
    List<Education> findEducations();
    Education findWithAdvertisementById(Integer id);

}
