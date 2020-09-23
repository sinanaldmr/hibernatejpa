package com.hibernatejpa.repository.impl;

import com.hibernatejpa.model.Advertisement;
import com.hibernatejpa.model.User;
import com.hibernatejpa.model.UserDetail;
import com.hibernatejpa.model.UserInfo;
import com.hibernatejpa.repository.UserRepository;

import javax.persistence.*;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    private EntityManager entityManager=entityFactory.getEntityManager();
    private EntityTransaction transaction=this.entityManager.getTransaction();

    @Override
    public boolean saveUser(User user) {
        try{
            this.transaction.begin();
            this.entityManager.persist(user);
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
    public boolean updateUser(User user) {
        try{
            this.transaction.begin();
            this.entityManager.merge(user);
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
        return true;    }

    @Override
    public boolean removeUser(User user) {
        try{
            if (this.entityManager.contains(user)){
                this.entityManager.remove(user);
            }else {
                User deleteUser=this.findById(user.getUserId());
                this.entityManager.remove(deleteUser);
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
    public User findById(Integer id) {
        User user=null;
        try{
            TypedQuery<User> typedQuery=entityManager.createNamedQuery("User.findById",User.class);
            typedQuery.setParameter("userId",id);
            user=typedQuery.getSingleResult();
        }catch (NoResultException e){
            System.err.println("Error:"+e);
        }
        return user;
    }

    @Override
    public User findByUsername(String username) {
        User user=null;
        try{
            TypedQuery<User> typedQuery=entityManager.createNamedQuery("User.findByUsername",User.class);
            typedQuery.setParameter("username",username);
            user=typedQuery.getSingleResult();
        }catch (NoResultException e){
            System.err.println("Error:"+e);
        }
        return user;
    }

    @Override
    public User findWithUserDetailByUsername(String username) {
        User user=null;
        try{
            TypedQuery<User> typedQuery=entityManager.createNamedQuery("User.findWithUserDetailByUsername",User.class);
            typedQuery.setParameter("username",username);
            user=typedQuery.getSingleResult();
        }catch (NoResultException e){
            System.err.println("Error:"+e);
        }
        return user;
    }

    @Override
    public List<User> findUsers() {
        List<User> users=null;
        try{
            TypedQuery<User> typedQuery=entityManager.createNamedQuery("User.findUsers",User.class);
            users=typedQuery.getResultList();
        }catch (NoResultException e){
            System.err.println("Error:"+e);
        }
        return users;
    }

    @Override
    public List<User> findUsers(int firstResult, int maxResult) {
        List<User> users=null;
        try{
            TypedQuery<User> typedQuery=entityManager.createNamedQuery("User.findUsers",User.class);
            typedQuery.setFirstResult(firstResult);
            typedQuery.setMaxResults(maxResult);
            users=typedQuery.getResultList();
        }catch (NoResultException e){
            System.err.println("Error:"+e);
        }
        return users;    }

    @Override
    public int findUserCount() {
        int count=0;
        try{
           Query query=this.entityManager.createNamedQuery("User.count");
           count=(int) query.getSingleResult();
        }catch (NoResultException e){
            System.err.println("Error:"+e);
        }
        return count;
    }

    @Override
    public UserInfo findUserInfoByUsername(String username) {
        UserInfo userInfo=null;
        try{
            TypedQuery<UserInfo> typedQuery=entityManager.createNamedQuery("User.findUserInfoByUsername",UserInfo.class);
            typedQuery.setParameter("username",username);
            userInfo=typedQuery.getSingleResult();
        }catch (NoResultException e){
            System.err.println("Error:"+e);
        }
        return userInfo;
    }
}
