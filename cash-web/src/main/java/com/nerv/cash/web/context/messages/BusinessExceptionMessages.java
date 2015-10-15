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
 * Classe que encapsula a tradução de mensagens de negócio lançadas
 * pelo contexto.
 * @author Vitor
 */
@ApplicationScoped
public class BusinessExceptionMessages implements Serializable {
    
    @Inject
    private MessageContext ctx;
    /**
     * Traduz o código da mensagem de negócio baseado no arquivo de propriedades
     * @param e A exceção de negócio lançada
     * @return Uma mensagem amigável baseada no código do erro 
     */
    public String translate(final BusinessException e) {
        Message message = ctx.message();
        return message.template("msg." + e.getCode()).toString();
    }
}