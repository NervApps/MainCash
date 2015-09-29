/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nerv.cash.services.api.facade;

import com.nerv.cash.services.api.service.Endpoints;
import com.nerv.cash.services.api.service.Pipelines;
import java.util.concurrent.Future;
import org.apache.camel.ExchangePattern;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;

/**
 *
 * @author Vitor
 */
public class BusinessFacade implements Facade {
    
    @Produce
    private ProducerTemplate producer;
    
    @Override
    public void call(final Endpoints target) {
        producer.sendBody(target.uri());
    }
    
    @Override
    public void call(final Endpoints target, final Object param) {
        call(target.uri(), param);
    }
    
    @Override
    public void call(final Pipelines target, final Object param) {
        call(target.uri(), param);
    }
    
    @Override
    public <T> T call(final Endpoints target, final Class<T> returnType) {
        return call(target.uri(), returnType);
    }
    
    @Override
    public <T> T call(final Endpoints target, final Object param, final Class<T> returnType) {
        return call(target.uri(), param, returnType);
    }
    
    @Override
    public <T> T call(final Pipelines target, final Object param, final Class<T> returnType) {
        return call(target.uri(), param, returnType);
    }
    
    @Override
    public <T> Future<T> callAsync(final Endpoints target, final Object param,
            final Class<T> returnType) {
        return callAsync(target.uri(), param, returnType);
    }
    
    @Override
    public <T> Future<T> callAsync(final Pipelines target, final Object param,
            final Class<T> returnType) {
        return callAsync(target.uri(), param, returnType);
    }
    
    private void call(final String uri, final Object param) {
        producer.sendBody(uri, param);
    }
    
    private <T> T call(final String uri, final Class<T> type) {
        return (T) producer.sendBody(uri, ExchangePattern.InOut, null);
    }
    
    private <T> T call(final String uri, final Object param, final Class<T> type) {
        return (T) producer.sendBody(uri, ExchangePattern.InOut, param);
    }
    
    private <T> Future<T> callAsync(final String uri, final Object param, final Class<T> type) {
        return producer.asyncRequestBody(uri, param, type);
    }
}