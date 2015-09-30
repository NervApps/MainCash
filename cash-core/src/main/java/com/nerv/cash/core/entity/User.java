/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nerv.cash.core.entity;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 * Classe que mapeia a tabela de usuários.
 * @author Vitor
 */
public class User {
    
    @Getter @Setter private String login;
    @Getter @Setter private String password;
    @Getter @Setter private Date lastLogin;
    
}
