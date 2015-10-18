/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nerv.cash.web.bean.auth;

import com.nerv.cash.core.entity.User;
import com.nerv.cash.web.stereotype.SessionModel;
import com.nerv.cash.web.stereotype.auth.Logged;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 * Classe que controla o usu�rio logado na aplica��o.
 * @author Vitor
 */
@SessionModel
public class LoginControl implements Serializable {
    
    private User logged;
    /**
     * Insere o usu�rio logado na sess�o.
     * @param user O usu�rio logado.
     */
    public void logon(final User user) {
        this.logged = user;
    }
    /**
     * Efetua o logoff e redireciona para a p�gina de login.
     * @return A refer�ncia para a p�gina de login.
     */
    public String logoff() {
        invalidate();
        this.logged = null;
        return "login?faces-redirect=true";
    }
    /**
     * Invalida a sess�o ativa do usu�rio.
     */
    private void invalidate() {
        FacesContext ctx = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) ctx.getExternalContext().getSession(false);
        if (session != null) {
            session.invalidate();
        }
    }

    /**
     * Retorna o usu�rio logado na aplica��o.
     * @return O usu�rio logado na aplica��o.
     */
    @Produces @SessionScoped @Logged
    public User getLogged() {
        return logged;
    }
}