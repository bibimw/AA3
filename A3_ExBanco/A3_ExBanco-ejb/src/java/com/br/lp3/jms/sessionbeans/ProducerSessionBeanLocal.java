package com.br.lp3.jms.sessionbeans;

import javax.ejb.Local;
import javax.jms.JMSException;

/**
 *
 * @author Bianca
 */
@Local
public interface ProducerSessionBeanLocal {
    public void sendMessageToBanco(String message) throws JMSException;
}
