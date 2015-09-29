/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nerv.cash.services.api.service;

import org.apache.camel.LoggingLevel;

/**
 * Uma especialização de {@link Pipeline} que invoca as rotas de maneira
 * assíncrona.
 * @author Vitor
 */
public abstract class Broadcast extends Pipeline {

    @Override
    public void configure() throws Exception {
        from(name().uri())
            .routeId(name().uri())
            .log(LoggingLevel.DEBUG, "init")
            .multicast()
            .parallelProcessing()
            .to(getTargetsUri())
            .log(LoggingLevel.DEBUG, "end");
    }
}