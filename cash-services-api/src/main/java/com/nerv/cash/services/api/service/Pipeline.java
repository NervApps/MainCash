/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nerv.cash.services.api.service;

import java.util.ArrayList;
import java.util.List;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
/**
 * Invoca as rotas sequencialmente, na ordem pré-definida.
 * @author Vitor
 */
public abstract class Pipeline extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from(name().uri())
            .routeId(name().uri())
            .log(LoggingLevel.DEBUG, "init")
            .pipeline(getTargetsUri())
            .log(LoggingLevel.DEBUG, "end");
    }    
    /**
     * Retorna todas as URIs dos endpoints alvo do pipeline.
     * @return Um array com toda sas URIs.
     */
    protected String[] getTargetsUri() {
        List<String> uris = new ArrayList<>();
        for (Endpoints service : targets()) {
            uris.add(service.uri());
        }
        return uris.toArray(new String[uris.size()]);
    }
    /**
     * Define o nome da rota no contexto.
     * @return O nome da rota.
     */
    protected abstract Pipelines name();
    /**
     * Os serviços que serão invocados na pipeline. A ordem definida no array
     * é a ordem que os serviços serão invocados.
     * @return Um array com os serviços invocados.
     */
    protected abstract Endpoints[] targets();
}