/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nerv.cash.services.api.service;

import java.io.Serializable;
import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

/**
 * Define uma rota e o seu processamento.
 * @param <T> o tipo do parâmetro esperado na requisição.
 * @author Vitor
 */
public abstract class Service<T> extends RouteBuilder implements Processor, Serializable {
    protected Exchange exchange;

    @Override
    public void process(Exchange exchange) throws Exception {
        this.exchange = exchange;
        handle((T) exchange.getIn().getBody());
        this.exchange = null;
    }
    
    @Override
    public void configure() throws Exception {
        from(name().uri())
            .routeId(name().uri())
            .log(LoggingLevel.DEBUG, "started")
            .process(this)
            .log(LoggingLevel.DEBUG, "finished");
    }
    /**
     * Atualiza os dados da requisição para a próxima rota.
     * @param body O objeto que será enviado.
     */
    protected void updateRequest(final Object body) {
        exchange.getIn().setBody(body);
    }
    /**
     * Atualiza os dados da resposta.
     * @param body O objeto que será inserido na resposta do serviço.
     */
    protected void setResponse(final Object body) {
        updateRequest(body);
        exchange.getOut().setBody(body);
    }
    /**
     * Define o nome da rota no contexto.
     * @return O nome da rota.
     */
    protected abstract Endpoints name();
    /**
     * Manipula a mensagem enviada pela rota.
     * @param body O corpo da mensagem
     */
    protected abstract void handle(T body);
}
