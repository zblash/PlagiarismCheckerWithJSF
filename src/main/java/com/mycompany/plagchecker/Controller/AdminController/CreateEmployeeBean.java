/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.plagchecker.Controller.AdminController;

import com.mycompany.plagchecker.Model.User;
import com.mycompany.plagchecker.queries.DataQuery;
import java.security.MessageDigest;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean(name="admincreateemployeeBean")
@ViewScoped
public class CreateEmployeeBean {
   private String username;
    private String email;
    private String password;
    private String firstname;
    private String lastname;
    private Integer credit_limit;
    private User u;
    private DataQuery dataquery = new DataQuery();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Integer getCredit_limit() {
        return credit_limit;
    }

    public void setCredit_limit(Integer credit_limit) {
        this.credit_limit = credit_limit;
    }


    public void createUser(){
        u = new User();
        try{
        MessageDigest messageDigestNesnesi = MessageDigest.getInstance("MD5");
        messageDigestNesnesi.update(password.getBytes());
        byte messageDigestDizisi[] = messageDigestNesnesi.digest();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < messageDigestDizisi.length; i++) {
        sb.append(Integer.toString((messageDigestDizisi[i] & 0xff) + 0x100, 16).substring(1));
        }
        u = new User(email,username,firstname,lastname,sb.toString(),5);
        u.setIsenabled(true);
        dataquery.createUser(u,null,"admin");
        
            FacesMessage message = new FacesMessage();
            message.setDetail("Başarili");
            message.setSummary("Yetkili Başarıyla Eklendi.");
            message.setSeverity(FacesMessage.SEVERITY_INFO);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }catch(Exception e){
            FacesMessage message = new FacesMessage();
            message.setDetail("Başarisiz");
            message.setSummary("İşlem Sırasında Bir Hata Oluştu.");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
}
