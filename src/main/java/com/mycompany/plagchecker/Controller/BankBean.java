/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.plagchecker.Controller;

import com.mycompany.plagchecker.Model.Bank;
import com.mycompany.plagchecker.Model.Pricing;
import com.mycompany.plagchecker.queries.DataQuery;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name="bankaccountsBean")
@ViewScoped
public class BankBean {
    
    private List<Bank> banks;
    private DataQuery dataquery = new DataQuery();
    
        @PostConstruct
    public void init(){
        banks = dataquery.getBanks();
    }

    public List<Bank> getBanks() {
        return banks;
    }

    public void setBanks(List<Bank> banks) {
        this.banks = banks;
    }
    
}
