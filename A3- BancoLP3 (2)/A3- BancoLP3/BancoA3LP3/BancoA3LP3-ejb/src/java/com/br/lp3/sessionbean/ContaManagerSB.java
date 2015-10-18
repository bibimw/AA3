    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.sessionbean;

import com.br.lp3.entities.Conta;
import com.br.lp3.jms.sessionbeans.ProducesSBLocal;
import com.br.lp3.model.dao.ContaDAO;
import com.br.lp3.model.dao.GenericDAO;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.jms.JMSException;

/**
 *
 * @author 31400051
 */
@Stateful
public class ContaManagerSB implements ContaManagerSBLocal {
    @EJB
    private ProducesSBLocal producesSB;
    
    
    

    @Override
    public List<Conta> buscarConta() {
        List<Conta> lista = new ArrayList();
        GenericDAO servico = new ContaDAO();
        lista = servico.read();
        return lista;
    }

    @Override
    public boolean transferir(int id_conta1, int id_conta2, double valor) {
        GenericDAO servico = new ContaDAO();
        double novoSaldoConta1;
        double novoSaldoConta2;
        List<Conta> lista = buscarConta();
        for (Conta conta1 : lista) {
            if (conta1.getIdConta().equals(id_conta1)) {
                if (conta1.getSaldo() < valor) {
                    return false;
                } else {
                    for (Conta conta2 : lista) {
                        if (conta2.getIdConta().equals(id_conta2)) {
                            novoSaldoConta1 = conta1.getSaldo() - valor;
                            novoSaldoConta2 = conta2.getSaldo() + valor;
                            conta1.setSaldo(novoSaldoConta1);
                            conta2.setSaldo(novoSaldoConta2);
                            servico.update(conta1);
                            servico.update(conta2);
                            try {
                                producesSB.sendMessage("Transferência de " + conta1.getNomeConta() + " para " + conta2.getNomeConta() + "bem sucedida: você transferiu R$" + valor);
                            } catch (JMSException ex) {
                                System.out.println(ex.getMessage());
                            }
                        }
                    }
                }
            }
        }

        return true;
    }

    @Override
    public boolean sacar(int id, double valor) {

        GenericDAO servico = new ContaDAO();

        double novoSaldo;
        List<Conta> lista = buscarConta();
        for (Conta conta : lista) {
            if (conta.getIdConta().equals(id)) {

                if (conta.getSaldo() < valor) {
                    return false;
                } else {
                    novoSaldo = conta.getSaldo() - valor;
                    conta.setSaldo(novoSaldo);
                    servico.update(conta);
                    try {
                        producesSB.sendMessage("Saque em (" + conta.getNomeConta() + ") bem sucedido: você sacou R$" + valor);
                    } catch (JMSException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            }
        }

        return true;
    }
}
