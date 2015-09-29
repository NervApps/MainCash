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
     * O nome padr�o do contexto do camel na aplica��o.
     */
    public static final String CTX_NAME = "app-context";
    /**
     * O prefixo de lookup das rotas expostas no contexto.
     */
    public static final String ENDPOINT_PREFIX = "direct:";
    /**
     * Classe de constantes, n�o pode ser instanciada.
     */
    private Context() {}
}
