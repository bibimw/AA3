/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.sessionbean;

import com.br.lp3.entities.Usuario;
import com.br.lp3.jms.sessionbeans.ProducesSBLocal;
import com.br.lp3.model.dao.GenericDAO;
import com.br.lp3.model.dao.UsuarioDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.jms.JMSException;

/**
 *
 * @author 31400051
 */
@Stateful
public class LoginManagerSB implements LoginManagerSBLocal {

    @EJB
    private ProducesSBLocal producesSB;

    @Override
    public List<Usuario> buscarUsuario() {
        List<Usuario> lista = new ArrayList();
        GenericDAO servico = new UsuarioDAO();
        lista = servico.read();
        return lista;
    }

    @Override
    public boolean authorize(String username, String password) {
        List<Usuario> lista = buscarUsuario();
        for (Usuario usuario : lista) {
            if (usuario.getLogin().equals(username) && usuario.getSenha().equals(password)) {
                try {
                    producesSB.sendMessage(username + " logou no sistema.");
                } catch (JMSException ex) {
                    System.out.println(ex.getMessage());
                }
                return true;
            }
        }
       
        return false;
    }
}
