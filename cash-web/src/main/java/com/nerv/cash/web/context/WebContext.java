/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nerv.cash.web.context;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import static javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

/**
 * Classe com m�todos utilit�rios para serem usados no contexto da aplica��o.
 * @author Vitor
 */
@RequestScoped
public class WebContext {
    /**
     * Insere uma mensagem informativa no contexto.
     * @param message A mensagem que ser� exibida.
     */
    public void infoMessage(String message) {
        putMessage(message, FacesMessage.SEVERITY_INFO);
    }
    /**
     * Insere uma mensagem de erro no contexto.
     * @param message A mensagem que ser� exibida.
     */
    public void errorMessage(final String message) {
        putMessage(message, FacesMessage.SEVERITY_ERROR);
    }
    /**
     * Insere uma mensagem de alerta no contexto.
     * @param message A mensagem que ser� exibida.
     */
    public void warnMessage(final String message) {
        putMessage(message, FacesMessage.SEVERITY_WARN);
    }
    /**
     * Coloca a mensagem no contexto.
     * @param message A mensagem que ser� exibida.
     * @param severity A severidade da mensagem.
     */
    private void putMessage(String message, Severity severity) {
        putMessage(message, null, severity);
    }
    /**
     * Coloca a mensagem no contexto.
     * @param message A mensagem que ser� exibida.
     * @param detail O detalhe da mensagem.
     * @param severity  A severidade da mensagem.
     */
    private void putMessage(String message, String detail, Severity severity) {
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.addMessage(null, buildMessage(severity, message, detail));
    }
    /**
     * Constr�i a mensagem que ir� no contexto.
     * @param severity A severidade da mensagem.
     * @param message A mensagem que ser� exibida.
     * @param detail O detalhe da mensagem.
     * @return O objeto com as informa��es.
     */
    private FacesMessage buildMessage(Severity severity, 
            String message, String detail) {
        return new FacesMessage(severity, message, detail);
    }
}