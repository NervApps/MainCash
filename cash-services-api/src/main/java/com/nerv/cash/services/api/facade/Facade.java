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
 * Interface que define os m�todos de invoca��o de servi�os e pipelines.
 * @author Vitor
 */
public interface Facade {
    /**
     * Efetua a chamada de um servi�o.
     * @param target O servi�o alvo.
     */
    void call(final Endpoints target);
    /**
     * Efetua a chamada de um servi�o.
     * @param target O servi�o alvo.
     * @param param O par�metro que ser� enviado para o servi�o.
     */
    void call(final Endpoints target, final Object param);
    /**
     * Efetua a chamada de uma pipeline.
     * @param target A pipeline alvo.
     * @param param O par�metro que ser� enviado para o primeiro servi�o
     * da pipeline.
     */
    void call(final Pipelines target, final Object param);
    /**
     * Efetua a chamada de um servi�o.
     * @param target O servi�o alvo.
     * @param returnType O tipo do retorno esperado.
     */
    <T> T call(final Endpoints target, final Class<T> returnType);
    /**
     * Efetua a chamada de um servi�o.
     * @param target O servi�o alvo.
     * @param param O par�metro que ser� enviado para o servi�o.
     * @param returnType O tipo do retorno esperado.
     * @return O objeto retornado pelo servi�o.
     */
    <T> T call(final Endpoints target, final Object param, final Class<T> returnType);
    /**
     * Efetua a chamada de uma pipeline.
     * @param target A pipeline alvo.
     * @param param O par�metro que ser� enviado para o primeiro servi�o
     * da pipeline.
     * @param returnType O tipo do retorno esperado.
     * @return O objeto retornado pela pipeline.
     */
    <T> T call(final Pipelines target, final Object param, final Class<T> returnType);
    /**
     * Efetua a chamada de um servi�o ass�ncrono.
     * @param target O servi�o alvo.
     * @param param O par�metro que ser� enviado para o servi�o.
     * @param returnType O tipo do retorno esperado.
     * @return Um {@link Future} representando a invoca��o ass�ncrona do servi�o.
     */
    <T> Future<T> callAsync(final Endpoints target, final Object param, final Class<T> returnType);
    /**
     * Efetua a chamada de uma pipeline ass�ncrona.
     * @param target A pipeline alvo.
     * @param param O par�metro que ser� enviado para o primeiro servi�o
     * da pipeline.
     * @param returnType O tipo do retorno esperado.
     * @return Um {@link Future} representando a invoca��o ass�ncrona da pipeline.
     */
    <T> Future<T> callAsync(final Pipelines target, final Object param, final Class<T> returnType);
}