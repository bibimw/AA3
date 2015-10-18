/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.jms.sessionbeans;

import javax.ejb.Local;
import javax.jms.JMSException;

/**
 *
 * @author dahda
 */
@Local
public interface ProducesSBLocal {
    public void sendMessage(String msg) throws JMSException;
}
