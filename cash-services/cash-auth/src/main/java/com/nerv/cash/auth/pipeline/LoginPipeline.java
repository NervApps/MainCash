/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nerv.cash.auth.pipeline;

import com.nerv.cash.services.api.Context;
import com.nerv.cash.services.api.service.Endpoints;
import com.nerv.cash.services.api.service.Pipeline;
import com.nerv.cash.services.api.service.Pipelines;
import javax.enterprise.context.ApplicationScoped;
import org.apache.camel.cdi.ContextName;

/**
 * Pipeline de logon do usuário na aplicação.
 * @author Vitor
 */
@ApplicationScoped
@ContextName(value = Context.CTX_NAME)
public class LoginPipeline extends Pipeline {

    @Override
    protected Pipelines name() {
        return Pipelines.LOGIN;
    }

    @Override
    protected Endpoints[] targets() {
        return new Endpoints[] {
            Endpoints.GET_BY_USR_PWD,
            Endpoints.UPDATE_LAST_LOGIN
        };
    }
}
