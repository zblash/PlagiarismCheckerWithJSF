/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.plagchecker.Controller.AdminController;

import com.mycompany.plagchecker.Model.Pricing;
import com.mycompany.plagchecker.queries.DataQuery;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name="adminpricingeditBean")
@ViewScoped
public class PricingEditBean implements Serializable {
    
    private Long pricingid;
    private Long id;
    private int credit;
    private int price;
    private String firsttab;
    private String secondtab;
    private String thirdtab;
    private String fourthtab;
    private DataQuery dataquery = new DataQuery();
    private Pricing p;
    
     public void init(){
        String value = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("pricingid");
        FacesContext fc = FacesContext.getCurrentInstance();
        ConfigurableNavigationHandler nav = (ConfigurableNavigationHandler) fc.getApplication().getNavigationHandler();
        try{
            id = Long.parseLong(value);
            p = dataquery.pricingfindById(id);
            pricingid = p.getPricingid();
            credit = p.getCredit();
            price = p.getPrice();
            firsttab = p.getFirsttab();
            secondtab = p.getSecondtab();
            thirdtab = p.getThirdtab();
            fourthtab = p.getFourthtab();
            
        }catch(Exception e){
                System.out.println("hata yusuf");
                nav.performNavigation("/admin/pricing.xhtml?faces-redirect=true");
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPricingid() {
        return pricingid;
    }

    public void setPricingid(Long pricingid) {
        this.pricingid = pricingid;
    }

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
    public void edit(){
        try{
            p.setCredit(credit);
            p.setPrice(price);
            p.setFirsttab(firsttab);
            p.setSecondtab(secondtab);
            p.setThirdtab(thirdtab);
            p.setFourthtab(fourthtab);
            dataquery.updatePricing(p, pricingid);
            FacesMessage message = new FacesMessage();
            message.setDetail("Fiyatlandırma Güncellendi");
            message.setSummary("Fiyatlandırma Güncellendi");
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
