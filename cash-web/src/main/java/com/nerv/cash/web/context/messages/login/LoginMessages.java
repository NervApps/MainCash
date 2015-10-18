/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nerv.cash.web.context.messages.login;

import org.apache.deltaspike.core.api.message.MessageBundle;
import org.apache.deltaspike.core.api.message.MessageTemplate;

/**
 * Classe que encapsula as mensagens do módulo de login da aplicação.
 * @author Vitor
 */
@MessageBundle
public interface LoginMessages {
    @MessageTemplate("{user.create}")
    String userCreate();
    @MessageTemplate("{user.create.error}")
    String userCreateError();
    @MessageTemplate("{user.password.unmatch}")
    String userPasswordUnmatch();
    @MessageTemplate("{user.login.invalid}")
    String userLoginInvalid();
    @MessageTemplate("{user.login.invalid.detail}")
    String userLoginInvalidDetail();
    @MessageTemplate("{user.not.found}")
    String userNotFound();
}