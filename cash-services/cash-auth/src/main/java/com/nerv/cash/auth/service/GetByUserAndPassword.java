/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nerv.cash.auth.service;

import com.nerv.cash.auth.dao.UserDAO;
import com.nerv.cash.core.entity.User;
import com.nerv.cash.core.exception.BusinessException;
import com.nerv.cash.services.api.Context;
import com.nerv.cash.services.api.service.Endpoints;
import com.nerv.cash.services.api.service.Service;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import org.apache.camel.cdi.ContextName;

/**
 * Serviço que verifica se o usuário existe na base.
 * @author Vitor
 */
//@ApplicationScoped
//@ContextName(value = Context.CTX_NAME)
public class GetByUserAndPassword extends Service<User> {
    
    @Inject @RequestScoped private UserDAO dao;

    @Override
    protected Endpoints name() {
        return Endpoints.GET_BY_USR_PWD;
    }

    @Override
    protected void handle(User body) {
        User found = dao.findByLoginAndPassword(body.getLogin(), body.getPassword());
        if (found == null)
            throw new BusinessException("user.notFound");
        else
            setResponse(found);
    }
}