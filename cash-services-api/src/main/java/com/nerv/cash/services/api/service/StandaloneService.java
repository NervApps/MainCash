/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nerv.cash.services.api.service;

import org.apache.camel.Exchange;

/**
 * Invoca a rota alvo e executa o seu processamento.
 * @param <T> o tipo do parâmetro esperado na requisição.
 * @author Vitor
 */
public abstract class StandaloneService<T> extends Service<T> {

    @Override
    public void process(Exchange exchange) throws Exception {
        this.exchange = exchange;
        execute();
        this.exchange = null;
    }
    
    /**
     * Intercepta a chamada da rota e executa uma ação.
     */
    protected abstract void execute();

    @Override
    protected void handle(T body) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}