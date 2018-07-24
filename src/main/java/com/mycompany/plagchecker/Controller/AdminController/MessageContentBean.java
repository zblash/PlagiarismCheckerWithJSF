/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.plagchecker.Controller.AdminController;

import com.mycompany.plagchecker.Model.Contact;
import com.mycompany.plagchecker.queries.DataQuery;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name="adminmessagecontentBean")
@ViewScoped
public class MessageContentBean {
    
    private String email;
    private String name;
    private String message;
    private Long id;
    private DataQuery dataquery = new DataQuery();
    private Contact c;
    
    
    
    public void init(){
        String value = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("contact");
        FacesContext fc = FacesContext.getCurrentInstance();
        ConfigurableNavigationHandler nav = (ConfigurableNavigationHandler) fc.getApplication().getNavigationHandler();
        try{
            id = Long.parseLong(value);
            c = dataquery.findMessageById(id);
            email = c.getEmail();
            name = c.getName();
            message = c.getMessage();

        }catch(Exception e){
                    System.out.println("hata yusuf");
                    nav.performNavigation("/admin/messageindex.xhtml?faces-redirect=true");
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
}
