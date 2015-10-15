/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nerv.cash.web.context.messages;

import com.nerv.cash.core.exception.BusinessException;
import java.io.Serializable;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import org.apache.deltaspike.core.api.message.Message;
import org.apache.deltaspike.core.api.message.MessageContext;

/**
 * Classe que encapsula a tradu��o de mensagens de neg�cio lan�adas
 * pelo contexto.
 * @author Vitor
 */
@ApplicationScoped
public class BusinessExceptionMessages implements Serializable {
    
    @Inject
    private MessageContext ctx;
    /**
     * Traduz o c�digo da mensagem de neg�cio baseado no arquivo de propriedades
     * @param e A exce��o de neg�cio lan�ada
     * @return Uma mensagem amig�vel baseada no c�digo do erro 
     */
    public String translate(final BusinessException e) {
        Message message = ctx.message();
        return message.template("msg." + e.getCode()).toString();
    }
}