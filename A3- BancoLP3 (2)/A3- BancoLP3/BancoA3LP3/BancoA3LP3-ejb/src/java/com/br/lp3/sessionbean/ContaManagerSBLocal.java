/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.sessionbean;

import com.br.lp3.entities.Conta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 31400051
 */
@Local
public interface ContaManagerSBLocal {
    
    public List<Conta> buscarConta();
    public boolean transferir(int id_conta1, int id_conta2, double valor);     
    public boolean sacar(int id, double valor);
}
