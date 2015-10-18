/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nerv.cash.auth.dao;

import com.nerv.cash.core.entity.User;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Query;
import org.apache.deltaspike.data.api.Repository;
import org.apache.deltaspike.data.api.SingleResultType;

/**
 * Camada de acesso a dados de usuário.
 * @author Vitor
 */
//@Repository
public interface UserDAO extends EntityRepository<User, Long> {
    /**
     * Obtém o usuário de acordo com o login ou null caso o login não exista.
     * @param login O login do usuário.
     * @param password A senha do usuário.
     * @return O usuário encontrado na base de dados
     */
    @Query(singleResult = SingleResultType.OPTIONAL)
    User findByLoginAndPassword(String login, String password);
}
