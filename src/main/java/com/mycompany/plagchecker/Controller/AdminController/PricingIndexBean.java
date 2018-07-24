/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.plagchecker.Controller.AdminController;

import com.mycompany.plagchecker.Model.Pricing;
import com.mycompany.plagchecker.queries.DataQuery;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name="adminpricingBean")
@ViewScoped
public class PricingIndexBean implements Serializable {
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
    
}
