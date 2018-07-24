package com.mycompany.plagchecker.Controller;

import com.mycompany.plagchecker.Model.Report;
import com.mycompany.plagchecker.Model.Role;
import com.mycompany.plagchecker.Model.User;
import com.mycompany.plagchecker.queries.DataQuery;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean(name="profileBean")
@ViewScoped
public class ProfileBean implements Serializable {
    private String firstname;
    private String lastname;
    private String password;
    private List<Report> reports;
    private User u;
    private DataQuery dataquery = new DataQuery();
   
    @PostConstruct
    public void init(){
        HttpSession sess = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        u = (User)sess.getAttribute("user");
        firstname = u.getFirstname();
        lastname = u.getLastname();
        reports = dataquery.findReportsByUserId(u); 
    }
    
  
    public List<Report> getReports() {
        return reports;
    }

    public void setReports(List<Report> reports) {
        this.reports = reports;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public void edit(){
        
        MessageDigest messageDigestNesnesi;
        try {
            messageDigestNesnesi = MessageDigest.getInstance("MD5");
            messageDigestNesnesi.update(password.getBytes());
            byte messageDigestDizisi[] = messageDigestNesnesi.digest();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < messageDigestDizisi.length; i++) {
            sb.append(Integer.toString((messageDigestDizisi[i] & 0xff) + 0x100, 16).substring(1));
            }
            u.setFirstname(firstname);
            u.setLastname(lastname);
            u.setIsenabled(u.isIsenabled());
            u.setCredit_limit(u.getCredit_limit());
            u.setUsername(u.getUsername());
            Role role = dataquery.rolefindByName("user");
            u.setRole(role);
            u.setPassword(sb.toString());
            dataquery.updateUser(u, u.getUserid());
            FacesMessage message = new FacesMessage();
            message.setDetail("Başarili");
            message.setSummary("Bilgiler Güncellendi");
            message.setSeverity(FacesMessage.SEVERITY_INFO);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } catch (NoSuchAlgorithmException ex) {
            FacesMessage message = new FacesMessage();
            message.setDetail("Başarisiz");
            message.setSummary("Bir Hata Oluştu");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
}
