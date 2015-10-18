/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nerv.cash.web.bean.auth;

import com.nerv.cash.business.facade.auth.UserFacade;
import com.nerv.cash.core.entity.User;
import com.nerv.cash.web.context.WebContext;
import com.nerv.cash.web.context.messages.login.LoginMessages;
import com.nerv.cash.web.stereotype.Model;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import lombok.Getter;
import lombok.Setter;

/**
 * Controlador da página login.xhtml
 * @author Vitor
 */
@Model
public class LoginBean {
    
    @Getter @Setter private String login;
    @Getter @Setter private String password;
    
    @Inject private UserFacade facade;
    @Inject private LoginControl control;
    @Inject private WebContext context;
    @Inject private LoginMessages messages;
    
    @PostConstruct
    public void init() {
        login = new String();
        password = new String();
    }
    
    public String doLogin() {
        User usr = facade.doLogin(login, password);
        if (usr != null) {
            control.logon(usr);
            return "empty-page?faces-redirect=true";
        } else {
            context.errorMessage(messages.userNotFound());
            return null;
        }
    }
}