package com.hibernatejpa.entityfactory;

import javax.persistence.EntityManager;

public interface EntityFactory {
    EntityManager getEntityManager();
}
