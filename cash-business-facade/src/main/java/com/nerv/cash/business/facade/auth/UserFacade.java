/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nerv.cash.business.facade.auth;

import com.nerv.cash.core.entity.User;
import com.nerv.cash.core.util.Hasher;
import com.nerv.cash.services.api.facade.Facade;
import com.nerv.cash.services.api.service.Pipelines;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 * Facade que encapsula as operações disponíveis para o módulo de autenticação.
 * @author Vitor
 */
@RequestScoped
public class UserFacade {
    
    @Inject private Facade facade;
    @Inject private Hasher hasher;
    
    public User doLogin(String login, String password) {
        User user = new User();
        user.setLogin(login);
        user.setPassword(hasher.md5Hash(password));
        return facade.call(Pipelines.LOGIN, user, User.class);
    }
}