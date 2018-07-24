package com.mycompany.plagchecker.Controller;
 
import java.io.Serializable;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
 
@ManagedBean(name="userView")
@SessionScoped
public class UserView implements Serializable {
     
    private String firstname;
    private String lastname;
    private Locale locale;

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    @PostConstruct
    public void init() {
        locale = FacesContext.getCurrentInstance().getExternalContext().getRequestLocale();
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
 
    public void save() {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Welcome " + firstname + " " + lastname));
    }
    public String actionturkish(){
        locale = new Locale("tr");
        FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
        return null;
    }
     public String actionenglish(){
        locale = new Locale("en");
        FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
        return null;
    }
}