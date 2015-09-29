/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nerv.cash.services.api.facade;

import com.nerv.cash.services.api.service.Endpoints;
import com.nerv.cash.services.api.service.Pipelines;
import java.util.concurrent.Future;

/**
 * Interface que define os métodos de invocação de serviços e pipelines.
 * @author Vitor
 */
public interface Facade {
    /**
     * Efetua a chamada de um serviço.
     * @param target O serviço alvo.
     */
    void call(final Endpoints target);
    /**
     * Efetua a chamada de um serviço.
     * @param target O serviço alvo.
     * @param param O parâmetro que será enviado para o serviço.
     */
    void call(final Endpoints target, final Object param);
    /**
     * Efetua a chamada de uma pipeline.
     * @param target A pipeline alvo.
     * @param param O parâmetro que será enviado para o primeiro serviço
     * da pipeline.
     */
    void call(final Pipelines target, final Object param);
    /**
     * Efetua a chamada de um serviço.
     * @param target O serviço alvo.
     * @param returnType O tipo do retorno esperado.
     */
    <T> T call(final Endpoints target, final Class<T> returnType);
    /**
     * Efetua a chamada de um serviço.
     * @param target O serviço alvo.
     * @param param O parâmetro que será enviado para o serviço.
     * @param returnType O tipo do retorno esperado.
     * @return O objeto retornado pelo serviço.
     */
    <T> T call(final Endpoints target, final Object param, final Class<T> returnType);
    /**
     * Efetua a chamada de uma pipeline.
     * @param target A pipeline alvo.
     * @param param O parâmetro que será enviado para o primeiro serviço
     * da pipeline.
     * @param returnType O tipo do retorno esperado.
     * @return O objeto retornado pela pipeline.
     */
    <T> T call(final Pipelines target, final Object param, final Class<T> returnType);
    /**
     * Efetua a chamada de um serviço assíncrono.
     * @param target O serviço alvo.
     * @param param O parâmetro que será enviado para o serviço.
     * @param returnType O tipo do retorno esperado.
     * @return Um {@link Future} representando a invocação assíncrona do serviço.
     */
    <T> Future<T> callAsync(final Endpoints target, final Object param, final Class<T> returnType);
    /**
     * Efetua a chamada de uma pipeline assíncrona.
     * @param target A pipeline alvo.
     * @param param O parâmetro que será enviado para o primeiro serviço
     * da pipeline.
     * @param returnType O tipo do retorno esperado.
     * @return Um {@link Future} representando a invocação assíncrona da pipeline.
     */
    <T> Future<T> callAsync(final Pipelines target, final Object param, final Class<T> returnType);
}