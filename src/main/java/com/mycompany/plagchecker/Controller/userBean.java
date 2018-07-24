/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.plagchecker.Controller;

import com.mycompany.plagchecker.Model.User;
import com.mycompany.plagchecker.queries.DataQuery;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

/**
 *
 * @author Yusuf Can Çelik
 */
@ManagedBean(name = "userBean")
@SessionScoped
public class userBean implements Serializable {


   private String username;
   private String firstname;
   private String lastname;
   private String email;
   private int creditlimit;
   private String password;
   private final DataQuery dataquery = new DataQuery();
  
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
      return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public int getCreditlimit() {
        return creditlimit;
    }

    public void setCreditlimit(int creditlimit) {
        this.creditlimit = creditlimit;
    }
    public String login() throws NoSuchAlgorithmException {
        MessageDigest messageDigestNesnesi = MessageDigest.getInstance("MD5");
        messageDigestNesnesi.update(password.getBytes());
        byte messageDigestDizisi[] = messageDigestNesnesi.digest();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < messageDigestDizisi.length; i++) {
        sb.append(Integer.toString((messageDigestDizisi[i] & 0xff) + 0x100, 16).substring(1));
        }
        User u = dataquery.userlogincontrol(username, sb.toString());
        
        if(u != null){
                HttpSession sess = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                sess.setAttribute("user", u);
                
                return "success";
        }else{
            FacesMessage message = new FacesMessage();
            message.setDetail("Kullanıcı adı veya şifre yanlış");
            message.setSummary("Kullanıcı adı veya şifre yanlış");
            message.setSeverity(FacesMessage.SEVERITY_INFO);
            FacesContext.getCurrentInstance().addMessage(null, message);
            return "fail";
        }
       
        
    }
    public String logout(){
        HttpSession sess = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        sess.removeAttribute("user");
        
        sess.invalidate();
        return "success";
        
    }
    public void signup() throws NoSuchAlgorithmException{
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String url = req.getRequestURL().toString();
        url = url.substring(0, url.length() - req.getRequestURI().length()) + req.getContextPath() + "/";
        MessageDigest messageDigestNesnesi = MessageDigest.getInstance("MD5");
        messageDigestNesnesi.update(password.getBytes());
        byte messageDigestDizisi[] = messageDigestNesnesi.digest();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < messageDigestDizisi.length; i++) {
        sb.append(Integer.toString((messageDigestDizisi[i] & 0xff) + 0x100, 16).substring(1));
        }
        User u = new User(email,username,firstname,lastname,sb.toString(),5);
        u.setIsenabled(false);
        
        dataquery.createUser(u,url,"user");
        FacesMessage message = new FacesMessage();
            message.setDetail("Başarili");
            message.setSummary("Aktivasyon kodu mail adresine gönderildi.");
            message.setSeverity(FacesMessage.SEVERITY_INFO);
            FacesContext.getCurrentInstance().addMessage(null, message);
    
    }
}
