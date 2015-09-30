/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nerv.cash.auth.service;

import com.nerv.cash.core.entity.User;
import com.nerv.cash.services.api.Context;
import com.nerv.cash.services.api.service.Endpoints;
import com.nerv.cash.services.api.service.Service;
import javax.enterprise.context.ApplicationScoped;
import org.apache.camel.cdi.ContextName;
import org.joda.time.DateTime;

/**
 * Serviço que verifica se o usuário existe na base.
 * @author Vitor
 */
@ApplicationScoped
@ContextName(value = Context.CTX_NAME)
public class UpdateLastLogin extends Service<User> {

    @Override
    protected Endpoints name() {
        return Endpoints.UPDATE_LAST_LOGIN;
    }

    @Override
    protected void handle(User body) {
        body.setLastLogin(new DateTime().toDate());
        setResponse(body);
    }
}