/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.plagchecker.Controller;

import com.mycompany.plagchecker.Model.OrderPricing;
import com.mycompany.plagchecker.Model.Pricing;
import com.mycompany.plagchecker.Model.User;
import com.mycompany.plagchecker.queries.DataQuery;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean(name="pricingBean")
@ViewScoped
public class PricingBean implements Serializable {
    private User u;
    private Pricing p;

    private List<Pricing> pricinglist;
    private DataQuery dataquery = new DataQuery();
    
    @PostConstruct
    public void init(){
        pricinglist = dataquery.getAllPricing();
    }

    public List<Pricing> getPricinglist() {
        return pricinglist;
    }

    public void setPricinglist(List<Pricing> pricinglist) {
        this.pricinglist = pricinglist;
    }
    public void buy(Long id){
        HttpSession sess = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        if((u=(User)sess.getAttribute("user")) != null){
            OrderPricing o = new OrderPricing();
           p = dataquery.pricingfindById(id);
           o.setCredit(p.getCredit());
           o.setUser(u);
            System.out.println(o.getCredit()+" "+o.getUser().getUsername());
           dataquery.addOrder(o);
           FacesMessage message = new FacesMessage();
            message.setDetail("Başarılı");
            message.setSummary("Lütfen Banka Hesaplarımızdan Birisine Ödemeyi Yapın");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }else{
             FacesMessage message = new FacesMessage();
            message.setDetail("Başarisiz");
            message.setSummary("Lütfen Giriş Yapın");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
}
