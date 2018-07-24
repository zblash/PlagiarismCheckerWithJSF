/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.plagchecker.Controller;

import com.mycompany.plagchecker.Model.Contact;
import com.mycompany.plagchecker.queries.DataQuery;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name="contactBean")
@ViewScoped
public class ContactBean implements Serializable {
    private String name;
    private String email;
    private String message;
    private DataQuery dataquery = new DataQuery();
    private Contact c = new Contact();
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public void addmessage(){
        c.setEmail(email);
        c.setMessage(message);
        c.setName(name);
        try{
            dataquery.addContact(c);
            FacesMessage messages = new FacesMessage();
            messages.setDetail("Başarılı");
            messages.setSummary("Mesajınız Bize Ulaştı.");
            messages.setSeverity(FacesMessage.SEVERITY_INFO);
            FacesContext.getCurrentInstance().addMessage(null, messages);
        }catch(Exception e){
            FacesMessage messages = new FacesMessage();
            messages.setDetail("Başarısız");
            messages.setSummary("Bir Hata Oluştu");
            messages.setSeverity(FacesMessage.SEVERITY_INFO);
            FacesContext.getCurrentInstance().addMessage(null, messages);
        }
    }
}
