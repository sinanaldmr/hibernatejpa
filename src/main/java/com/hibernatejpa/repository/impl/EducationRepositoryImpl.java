package com.hibernatejpa.repository.impl;

import com.hibernatejpa.model.Education;
import com.hibernatejpa.repository.EducationRepository;

import javax.persistence.*;
import java.util.List;

public class EducationRepositoryImpl implements EducationRepository {
    private EntityManager entityManager=entityFactory.getEntityManager();
    private EntityTransaction transaction=this.entityManager.getTransaction();

    @Override
    public boolean saveEducation(final Education education) {
        try{
            this.transaction.begin();
            this.entityManager.persist(education);
            this.transaction.commit();
        }catch (RuntimeException e){
            System.err.println("Error: "+e);
            try{
                this.transaction.rollback();
            }catch (RollbackException e2){
                System.err.println("Error: "+e2);
            }
            return false;
        }
        return true;
    }

    @Override
    public boolean updateEducation(Education education) {
        try{
            this.transaction.begin();
            this.entityManager.merge(education);
            this.entityManager.flush();
            this.transaction.commit();
        }catch (RuntimeException e){
            System.err.println("Error: "+e);
            try{
                this.transaction.rollback();
            }catch (RollbackException e2){
                System.err.println("Error: "+e2);
            }
            return false;
        }
        return true;
    }

    @Override
    public boolean removeEducation(Education education) {
        try{
            if (this.entityManager.contains(education)){
                this.entityManager.remove(education);
            }else {
                Education deleteEducation=this.findById(education.getEducationId());
                this.entityManager.remove(deleteEducation);
            }
        }catch (RuntimeException e){
            System.err.println("Error: "+e);
            try{
                this.transaction.rollback();
            }catch (RollbackException e2){
                System.err.println("Error: "+e2);
            }
            return false;
        }
        return true;
    }

    @Override
    public Education findById(Integer id) {
        Education education=null;
        try{
            TypedQuery<Education> typedQuery=entityManager.createNamedQuery("Education.findById",Education.class);
            typedQuery.setParameter("educationId",id);
            education=typedQuery.getSingleResult();
        }catch (NoResultException e){
            System.err.println("Error:"+e);
        }
        return education;
    }

    @Override
    public List<Education> findEducations() {
        List<Education> educations=null;
        try{
            TypedQuery<Education> typedQuery=entityManager.createNamedQuery("Education.findEducations",Education.class);
            educations=typedQuery.getResultList();
        }catch (NoResultException e){
            System.err.println("Error:"+e);
        }
        return educations;
    }

    @Override
    public Education findWithAdvertisementById(Integer id) {
        Education education=null;
        try{
            TypedQuery<Education> typedQuery=entityManager.createNamedQuery("Education.findWithAdvertisements",Education.class);
            typedQuery.setParameter("educationId",id);
            education=typedQuery.getSingleResult();
        }catch (NoResultException e){
            System.err.println("Error:"+e);
        }
        return education;
    }
}
