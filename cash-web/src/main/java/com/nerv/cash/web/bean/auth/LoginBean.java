/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nerv.cash.web.bean.auth;

import com.nerv.cash.web.stereotype.Model;
import javax.annotation.PostConstruct;
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
    @Getter @Setter private String email;
    
    @PostConstruct
    public void init() {
        login = new String();
        password = new String();
        email = new String();
    }
    
    public void doLogin() {
        
    }
    
}
