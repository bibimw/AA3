/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.jms.mdbs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author dahda
 */
@MessageDriven(mappedName = "jms/dani", activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class ConsumerMDB implements MessageListener {
    
    public ConsumerMDB() {
    }
    
    @Override
    public void onMessage(Message message) {
        TextMessage tm = (TextMessage) message;
        String arquivo = "D:\\A3- BancoLP3\\log\\log.txt";
        try {
            byte[] bytes = carregar(new File(arquivo));
            
            
            String s = new String(bytes);
            
            
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            String dataSt = formatter.format(cal.getTime()); //horário do servidor
            String st = s +"\n(" + dataSt + ") " + tm.getText() + "\n";
            System.out.println(st);
            
            salvar(new File(arquivo), st);
        } catch (JMSException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static void salvar(File arquivo, String conteudo) throws IOException, Exception {
        FileOutputStream streamDeSaida = new FileOutputStream(arquivo);
        streamDeSaida.write(conteudo.getBytes());
        streamDeSaida.close();
    }
    
    public static byte[] carregar(File arquivo) throws Exception {
        FileInputStream dispositivoDeEntrada = new FileInputStream(arquivo);
        byte[] conteudo = new byte[dispositivoDeEntrada.available()];
        dispositivoDeEntrada.read(conteudo);
        return conteudo;
    }
    
}
