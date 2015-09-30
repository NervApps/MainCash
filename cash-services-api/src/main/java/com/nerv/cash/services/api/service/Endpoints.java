/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nerv.cash.services.api.service;

import com.nerv.cash.services.api.Context;
import lombok.Getter;

/**
 *
 * @author Vitor
 */
public enum Endpoints {
    GET_BY_USR_PWD("get-by-usr-pwd"),
    UPDATE_LAST_LOGIN("update-last-login");
    
    @Getter private final String name;

    private Endpoints(String name) {
        this.name = name;
    }
    
    public String uri() {
        return Context.ENDPOINT_PREFIX + name;
    }
}