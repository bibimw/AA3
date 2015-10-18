/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.jms.sessionbeans;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 *
 * @author dahda
 */
@Stateless
public class ProducesSB implements ProducesSBLocal {
    @Resource(mappedName = "jms/dani")
    private Queue dani;
    @Resource(mappedName = "jms/daniFactory")
    private ConnectionFactory daniFactory;

    private Message createJMSMessageForjmsDani(Session session, Object messageData) throws JMSException {
        // TODO create and populate message to send
        TextMessage tm = session.createTextMessage();
        tm.setText(messageData.toString());
        return tm;
    }
    
    @Override
    public void sendMessage(String msg) throws JMSException{
        sendJMSMessageToDani(msg);
    }

    private void sendJMSMessageToDani(Object messageData) throws JMSException {
        Connection connection = null;
        Session session = null;
        try {
            connection = daniFactory.createConnection();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer messageProducer = session.createProducer(dani);
            messageProducer.send(createJMSMessageForjmsDani(session, messageData));
        } finally {
            if (session != null) {
                try {
                    session.close();
                } catch (JMSException e) {
                    Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "Cannot close session", e);
                }
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    
}
