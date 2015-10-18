package com.br.lp3.jms.mdbs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import sun.util.logging.PlatformLogger;

/**
 *
 * @author Bianca
 */
@MessageDriven(mappedName = "jms/banco", activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class ConsumerMDB implements MessageListener {

    public ConsumerMDB() {
    }

    /*
     @Override
     public void onMessage(Message message) {
     TextMessage tm = (TextMessage) message;
     try{
     System.out.println(tm.getText());
     }catch(JMSException ex){
     Logger.getLogger(ConsumerMDB.class.getName()).log(Level.SEVERE, null, ex);
     }
     }
     */

    @Override
    public void onMessage(Message message) {
        TextMessage tm = (TextMessage) message;
        String arquivo = "C:\\Users\\Bianca\\Documents\\Mackenzie\\4ºsemestre\\LP III\\A3_ExBanco\\src\\log.txt";
        try {
            byte[] bytes = carregar(new File(arquivo));
            String s = new String(bytes);

            Calendar cal = Calendar.getInstance();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            String dataSt = formatter.format(cal.getTime());
            String st = s + "\n(" + dataSt + ") " + tm.getText() + "\n";
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
