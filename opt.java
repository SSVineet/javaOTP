/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamailer;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.MimeMessage;
import java.util.Random;

/**
 *
 * @author MAURYA
 */
public class opt {

    /**
     *
     * @param email
     * 
     */
      String id;
    public String opt1(String email){
        try{
            Random rand = new Random();
            int random = (int )(Math.random() * 10000 + 1);
            Scanner in = new Scanner(System.in);
           // System.out.println("Email addresss");
           // String email= in.nextLine();
            
           
           id = String.format("%04d", rand.nextInt(10000));
            
            //System.out.printf("%04d%n", rand.nextInt(10000));
            String host ="smtp.gmail.com" ;
            String user = "your email id ";
            String pass = "email id password ";
            String to = email;
            String from = "your email id ";
            String subject = "KNIT ERP LOGIN VERIFICATION";
            String messageText = "YOU ONE TIME OTP is "+id;
            boolean sessionDebug = false;

            Properties props = System.getProperties();

            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.required", "true");

          //  java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            Session mailSession = Session.getDefaultInstance(props, null);
            mailSession.setDebug(sessionDebug);
            Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(subject); 
            msg.setSentDate(new Date());
            msg.setText(messageText);

           Transport transport=mailSession.getTransport("smtp");
           transport.connect(host, user, pass);
           transport.sendMessage(msg, msg.getAllRecipients());
           transport.close();
           System.out.println("message send successfully"+" : "+id+"    (don't share)");
           
        }catch(Exception ex)
        {
            System.out.println(ex);
        }
        return(id);
        
    }

   
}
