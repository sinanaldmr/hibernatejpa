package com.hibernatejpa.repository.impl;

import com.hibernatejpa.model.Education;
import com.hibernatejpa.model.UserDetail;
import com.hibernatejpa.repository.UserDetailRepository;

import javax.persistence.*;

public class UserDetailRepositoryImpl implements UserDetailRepository {
    private EntityManager entityManager=entityFactory.getEntityManager();
    private EntityTransaction transaction=this.entityManager.getTransaction();

    @Override
    public boolean saveUserDetail(final UserDetail userDetail) {
        try{
            this.transaction.begin();
            this.entityManager.persist(userDetail);
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
    public boolean updateUserDetail(UserDetail userDetail) {
        try{
            this.transaction.begin();
            this.entityManager.merge(userDetail);
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
    public boolean removeUserDetail(UserDetail userDetail) {
        try{
            if (this.entityManager.contains(userDetail)){
                this.entityManager.remove(userDetail);
            }else {
                UserDetail deleteUserDetail=this.findById(userDetail.getUserDetailId());
                this.entityManager.remove(deleteUserDetail);
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
    public UserDetail findById(final Integer id) {
        UserDetail userDetail=null;
        try{
            userDetail=this.entityManager.find(UserDetail.class,id);
        }catch (NoResultException e){
            System.err.println("Error:"+e);
        }
        return userDetail;
    }

    @Override
    public UserDetail findByUserName(String username) {
        UserDetail userDetail=null;
        try{
            TypedQuery<UserDetail> typedQuery=entityManager.createNamedQuery("UserDetail.findByUsername",UserDetail.class);
            typedQuery.setParameter("username",username);
            userDetail=typedQuery.getSingleResult();
        }catch (NoResultException e){
            System.err.println("Error:"+e);
        }
        return userDetail;
    }

    @Override
    public UserDetail findWithAddressByUsername(String username) {
        UserDetail userDetail=null;
        try{
            TypedQuery<UserDetail> typedQuery=entityManager.createNamedQuery("UserDetail.findWithAddressByUsername",UserDetail.class);
            typedQuery.setParameter("username",username);
            userDetail=typedQuery.getSingleResult();
        }catch (NoResultException e){
            System.err.println("Error:"+e);
        }
        return userDetail;
    }

    @Override
    public UserDetail findWithAdvertisementByUsername(String username) {
        UserDetail userDetail=null;
        try{
            TypedQuery<UserDetail> typedQuery=entityManager.createNamedQuery("UserDetail.findWithAdvertisementByUsername",UserDetail.class);
            typedQuery.setParameter("username",username);
            userDetail=typedQuery.getSingleResult();
        }catch (NoResultException e){
            System.err.println("Error:"+e);
        }
        return userDetail;
    }
}
