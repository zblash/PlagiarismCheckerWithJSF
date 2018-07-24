/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.plagchecker.Controller.AdminController;

import com.mycompany.plagchecker.Model.Pricing;
import com.mycompany.plagchecker.queries.DataQuery;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name="admincreatepricingBean")
@ViewScoped
public class CreatePricingBean implements Serializable {
    private int credit;
    private int price;
    private String firsttab;
    private String secondtab;
    private String thirdtab;
    private String fourthtab;
    private DataQuery dataquery = new DataQuery();
    private Pricing p;
    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getFirsttab() {
        return firsttab;
    }

    public void setFirsttab(String firsttab) {
        this.firsttab = firsttab;
    }

    public String getSecondtab() {
        return secondtab;
    }

    public void setSecondtab(String secondtab) {
        this.secondtab = secondtab;
    }

    public String getThirdtab() {
        return thirdtab;
    }

    public void setThirdtab(String thirdtab) {
        this.thirdtab = thirdtab;
    }

    public String getFourthtab() {
        return fourthtab;
    }

    public void setFourthtab(String fourthtab) {
        this.fourthtab = fourthtab;
    }
    
    public void createPricing(){
        p = new Pricing(credit,price,firsttab,secondtab,thirdtab,fourthtab);
        try{
        dataquery.createPricing(p);
        FacesMessage message = new FacesMessage();
            message.setDetail("Başarili");
            message.setSummary("Yeni Fiyatlandırma Eklendi.");
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
