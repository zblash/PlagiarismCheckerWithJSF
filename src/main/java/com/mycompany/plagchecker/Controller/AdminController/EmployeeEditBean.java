/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.plagchecker.Controller.AdminController;

import com.mycompany.plagchecker.Model.Role;
import com.mycompany.plagchecker.Model.User;
import com.mycompany.plagchecker.queries.DataQuery;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "adminemployeeediteBean")
@ViewScoped
public class EmployeeEditBean {
    private String username;
    private String email;
    private String password;
    private String firstname;
    private String lastname;
    private Role role;
    private String rolename;
    private Integer credit_limit;
    private boolean isenabled;
    private Long userid;
    private User u;
    private DataQuery dataquery = new DataQuery();
    private Long id;
    
    
    public void init(){
        String value = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("user");
        FacesContext fc = FacesContext.getCurrentInstance();
        ConfigurableNavigationHandler nav = (ConfigurableNavigationHandler) fc.getApplication().getNavigationHandler();
        try{
                id = Long.parseLong(value);
                u = dataquery.userfindById(id);
                userid = u.getUserid();
                username = u.getUsername();
                email = u.getEmail();
                firstname = u.getFirstname();
                lastname = u.getLastname();
                credit_limit = u.getCredit_limit();
                isenabled = u.isIsenabled();
               
        }catch(Exception e){
                System.out.println("hata yusuf");
                nav.performNavigation("/admin/employeeindex.xhtml?faces-redirect=true");
        }
    }

    public Long getId() {
        return id;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Integer getCredit_limit() {
        return credit_limit;
    }

    public void setCredit_limit(Integer credit_limit) {
        this.credit_limit = credit_limit;
    }

    public boolean isIsenabled() {
        return isenabled;
    }

    public void setIsenabled(boolean isenabled) {
        this.isenabled = isenabled;
    }
    public void edit(){
        try{
            u.setFirstname(firstname);
            u.setLastname(lastname);
            u.setIsenabled(isenabled);
            u.setCredit_limit(credit_limit);
            u.setUsername(username);
            role = dataquery.rolefindByName(rolename);
            u.setRole(role);
            dataquery.updateUser(u, id);
            FacesMessage message = new FacesMessage();
            message.setDetail("Kullanıcı Güncellendi");
            message.setSummary("Kullanıcı Güncellendi");
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
