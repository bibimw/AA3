package com.br.lp3.jms.sessionbeans;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Bianca
 */
@Local
public interface OperacaoManagerLocal {
    public List<Conta> buscarConta();
    public boolean transferir(int id_conta1, int id_conta2, double valor);     
    public boolean sacar(int id, double valor);
}
