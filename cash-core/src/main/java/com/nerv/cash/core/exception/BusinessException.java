/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nerv.cash.core.exception;

import lombok.Getter;

/**
 * Exceção de negócio.
 * @author Vitor
 */
public class BusinessException extends RuntimeException {
    @Getter private final String code;

    public BusinessException(String code) {
        super(code);
        this.code = code;
    }
}
