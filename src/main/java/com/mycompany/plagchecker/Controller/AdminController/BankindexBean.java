/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.plagchecker.Controller.AdminController;

import com.mycompany.plagchecker.Model.Bank;
import com.mycompany.plagchecker.Model.User;
import com.mycompany.plagchecker.queries.DataQuery;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name="adminbankindexBean")
@ViewScoped
public class BankindexBean implements Serializable {
    private List<Bank> banks;
    private List<Bank> filteredBanks;
    private DataQuery dataquery = new DataQuery();
    private Bank selectedRow;

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

    public List<Bank> getFilteredBanks() {
        return filteredBanks;
    }

    public void setFilteredBanks(List<Bank> filteredBanks) {
        this.filteredBanks = filteredBanks;
    }

    public Bank getSelectedRow() {
        return selectedRow;
    }

    public void setSelectedRow(Bank selectedRow) {
        this.selectedRow = selectedRow;
    }
    public void removeBank(){
    banks.remove(selectedRow);
    dataquery.removeBank(selectedRow);
    selectedRow=null;
    }
}
