/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nerv.cash.services.api;

/**
 * Classe com constantes relativas ao contexto do camel.
 * @author Vitor
 */
public final class Context {
    /**
     * O nome padrão do contexto do camel na aplicação.
     */
    public static final String CTX_NAME = "app-context";
    /**
     * O prefixo de lookup das rotas expostas no contexto.
     */
    public static final String ENDPOINT_PREFIX = "direct:";
    /**
     * Classe de constantes, não pode ser instanciada.
     */
    private Context() {}
}
