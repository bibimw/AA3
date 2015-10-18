/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.sessionbean;

import com.br.lp3.entities.Usuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 31400051
 */
@Local
public interface LoginManagerSBLocal {
    public List<Usuario> buscarUsuario();
    
    public boolean authorize(String username, String password);
}
