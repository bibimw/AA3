package com.br.lp3.jms.sessionbeans;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jms.JMSException;

/**
 *
 * @author Bianca
 */
@Stateless
public class LoginManager implements LoginManagerLocal {

   @EJB
    private ProducerSessionBeanLocal producerSB;

    @Override
    public boolean authorize(String username, String password) {
        if("admin".equals(username) && "123".equals(password)|| "bibi".equals(username) && "345".equals(password)){
            try {
                producerSB.sendMessageToBanco("Usuário " + username + " logado com sucesso!");
            } catch (JMSException ex) {
                Logger.getLogger(LoginManager.class.getName()).log(Level.SEVERE, null, ex);
            }
            return true;
        }
        else{
            try {
                producerSB.sendMessageToBanco("Erro do login do usuario " + username);
            } catch (JMSException ex) {
                Logger.getLogger(LoginManager.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
        }
    }
}
