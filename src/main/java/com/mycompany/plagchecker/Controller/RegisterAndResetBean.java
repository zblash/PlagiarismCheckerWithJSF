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
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Yusuf Can Çelik
 */
@ManagedBean(name = "registerAndResetBean")
@ViewScoped
public class RegisterAndResetBean implements Serializable {

    private String email;
    
    String useruuid;
    
    private String password;
    
    private DataQuery dataquery = new DataQuery();
    

    
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUseruuid() {
        return useruuid;
    }

    public void setUseruuid(String useruuid) {
        this.useruuid = useruuid;
    }


    public void setEmail(String email) {
        this.email = email;
    }
    
    public void forgotpassword(){
        User u = dataquery.userfindByEmaill(email);
        System.out.println(u.getEmail());
        if(u != null){
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String url = req.getRequestURL().toString();
        url = url.substring(0, url.length() - req.getRequestURI().length()) + req.getContextPath() + "/";
        String mailcontent = "<h1>Hesabınızın şifresini değiştirmek için</h1></br> <a href=\""+url+"resetpassword.xhtml?uuid="+u.getTemporaryuuid()+"\">linke</a> tıklayınız";
        dataquery.sendMail("Şifrenizi Değiştirin",mailcontent,u.getEmail()); 
            FacesMessage message = new FacesMessage();
            message.setDetail("Başarılı");
            message.setSummary("Şifre Değiştirme Linki Gönderildi");
            message.setSeverity(FacesMessage.SEVERITY_INFO);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }else{
        FacesMessage message = new FacesMessage();
            message.setDetail("Başarısız");
            message.setSummary("Şifre Değiştirme Linki Gönderildi");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
         
        
    }
    @PostConstruct
    public void init(){
        
        useruuid = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("uuid");
    }
    public void resetpassword() throws NoSuchAlgorithmException{
        if(useruuid != null){
        MessageDigest messageDigestNesnesi = MessageDigest.getInstance("MD5");
        messageDigestNesnesi.update(password.getBytes());
        byte messageDigestDizisi[] = messageDigestNesnesi.digest();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < messageDigestDizisi.length; i++) {
        sb.append(Integer.toString((messageDigestDizisi[i] & 0xff) + 0x100, 16).substring(1));
        }
            if(dataquery.resetpassword(useruuid, sb.toString())){
            FacesMessage message = new FacesMessage();
            message.setDetail("Başarılı");
            message.setSummary("Şifre Değiştirildi");
            message.setSeverity(FacesMessage.SEVERITY_INFO);
            FacesContext.getCurrentInstance().addMessage(null, message);
            }else{
            FacesMessage message = new FacesMessage();
            message.setDetail("Hata");
            message.setSummary("Şifre Değiştirilemedi çünkü db");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage(null, message);
            }
        }else{
        FacesMessage message = new FacesMessage();
            message.setDetail("Hata");
            message.setSummary("Şifre Değiştirilemedi çünkü null");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage(null, message);
    }
    }
    public RegisterAndResetBean() {
    }
    
}
