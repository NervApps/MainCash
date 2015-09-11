/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nerv.cash.services.api.handler;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

/**
 *
 * @author Vitor
 * @param <T>
 */
public abstract class ServiceHandler<T> implements Processor {
    
    private Exchange exchange;

    public void process(Exchange exchng) throws Exception {
        this.exchange = exchng;
        handle((T) exchange.getIn().getBody());
    }
    
    protected void updateRequest(final Object body) {
        exchange.getIn().setBody(body);
    }
    
    protected void setResponse(final Object body) {
        updateRequest(body);
        exchange.getOut().setBody(body);
    }
    
    public abstract void handle(T body);
}