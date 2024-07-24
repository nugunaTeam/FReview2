package com.nuguna.freview.global.util;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class SendMailUtil {

  private final String ENCODING;
  private final String PORT;
  private final String SMTPHOST;
  private final String userName;
  private final String password;


  public SendMailUtil(String ENCODING, String PORT, String SMTPHOST, String userName, String password) {
    this.ENCODING = ENCODING;
    this.PORT = PORT;
    this.SMTPHOST = SMTPHOST;
    this.userName = userName;
    this.password = password;
  }


  public Session setting(Properties props){
    Session session = null;

    try{
      props.put("mail.transport.protocol","smtp");
      props.put("mail.smtp.host",SMTPHOST);
      props.put("mail.smt.port",PORT);
      props.put("mail.smtp.auth",true);
      props.put("mail.smtp.ssl.enable",true);
      props.put("mail.smtp.ssl.trust",SMTPHOST);
      props.put("mail.smtp.starttls.required",true);
      props.put("mail.smtp.starttls.enable",true);
      props.put("mail.smtp.ssl.protocols","TLSv1.2");

      props.put("mail.smtp.quit-wait","false");
      props.put("mail.smtp.socketFactory.port",PORT);
      props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
      props.put("mail.smtp.socketFactory.fallback","false");

      session = Session.getInstance(props, new Authenticator() {
        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
          return new PasswordAuthentication(userName, password);
        }
      });
    } catch(Exception e){
      System.out.println("Session setting 실패");
      e.printStackTrace();
    }

    return session;
  }

  public void goMail(Session session, String title, String content, String TO){

    Message msg = new MimeMessage(session);

    try{
      msg.setFrom(new InternetAddress("rlagkfka9611@google.com","FReview",ENCODING));
      msg.addRecipient(Message.RecipientType.TO, new InternetAddress(TO));
      msg.setSubject(title);
      msg.setContent(content, "text/html; charset=utf-8");

      Transport.send(msg);
      System.out.println("메일 보내기 성공");
    } catch(Exception e){

      e.printStackTrace();
      System.out.println("메일 보내시 실패");
    }
  }
}
