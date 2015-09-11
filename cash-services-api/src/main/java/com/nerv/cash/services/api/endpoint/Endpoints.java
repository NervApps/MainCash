/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nerv.cash.services.api.endpoint;

import lombok.Getter;

/**
 *
 * @author Vitor
 */
public enum Endpoints {
    VERIFY_USERNAME("verify-username");
    
    @Getter private final String name;
    private static final String PREFIX = "direct:";

    private Endpoints(String name) {
        this.name = name;
    }
    
    public String uri() {
        return PREFIX + name;
    }
}
