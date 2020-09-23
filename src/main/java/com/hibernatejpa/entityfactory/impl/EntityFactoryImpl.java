package com.hibernatejpa.entityfactory.impl;

import com.hibernatejpa.entityfactory.EntityFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityFactoryImpl implements EntityFactory {
    private EntityManager entityManager=null;

    @Override
    public EntityManager getEntityManager() {
        EntityManagerFactory factory= Persistence.createEntityManagerFactory("persistence-unit");
        return factory.createEntityManager();
    }
}
