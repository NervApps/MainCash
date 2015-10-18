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
 * Classe que controla o usuário logado na aplicação.
 * @author Vitor
 */
@SessionModel
public class LoginControl implements Serializable {
    
    private User logged;
    /**
     * Insere o usuário logado na sessão.
     * @param user O usuário logado.
     */
    public void logon(final User user) {
        this.logged = user;
    }
    /**
     * Efetua o logoff e redireciona para a página de login.
     * @return A referência para a página de login.
     */
    public String logoff() {
        invalidate();
        this.logged = null;
        return "login?faces-redirect=true";
    }
    /**
     * Invalida a sessão ativa do usuário.
     */
    private void invalidate() {
        FacesContext ctx = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) ctx.getExternalContext().getSession(false);
        if (session != null) {
            session.invalidate();
        }
    }

    /**
     * Retorna o usuário logado na aplicação.
     * @return O usuário logado na aplicação.
     */
    @Produces @SessionScoped @Logged
    public User getLogged() {
        return logged;
    }
}