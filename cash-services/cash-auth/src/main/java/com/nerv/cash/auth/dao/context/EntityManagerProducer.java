/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nerv.cash.auth.dao.context;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Fábrica de entity managers.
 * @author Vitor
 */
public class EntityManagerProducer {
    
    @Produces @ApplicationScoped
    public EntityManagerFactory createFactory() {
        return Persistence.createEntityManagerFactory("cash");
    }
    
    @Produces @RequestScoped
    public EntityManager create(EntityManagerFactory factory) {
        return factory.createEntityManager();
    }
    
    public void dispose(@Disposes EntityManager manager) {
        if (manager.isOpen())
            manager.close();
    }
}