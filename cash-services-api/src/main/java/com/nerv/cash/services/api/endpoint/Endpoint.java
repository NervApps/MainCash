/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nerv.cash.services.api.endpoint;

import com.nerv.cash.services.api.handler.ServiceHandler;
import org.apache.camel.LoggingLevel;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.deltaspike.core.api.provider.BeanProvider;

/**
 *
 * @author Vitor
 */
public abstract class Endpoint extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from(name().uri())
            .routeId(getClass().getSimpleName())
            .log(LoggingLevel.DEBUG, "init")
            .process(getHandleInstance())
            .log(LoggingLevel.DEBUG, "end");
    }
    /**
     * O nome do endpoint.
     * @return O enum correspondente ao nome do endpoint.
     */
    protected abstract Endpoints name();
    /**
     * O {@link ServiceHandler} correspondente ao endpoint.
     * @return A classe que representa o handler.
     */
    protected abstract Class<? extends Processor> handle();
    /**
     * Instancia o service handler no contexto CDI.
     * @return Uma implementação de {@link ServiceHandler} já injetada.
     */
    private Processor getHandleInstance() {
        return BeanProvider.getContextualReference(handle());
    }
}