/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.plagchecker.Controller.AdminController;

import com.mycompany.plagchecker.Model.Bank;
import com.mycompany.plagchecker.queries.DataQuery;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name="admincreatebankBean")
@ViewScoped
public class CreateBankAccountBean implements Serializable {
    private String owner;
    private String bankname;
    private String branchcode;
    private String accnumber;
    private String iban;
    private DataQuery dataquery = new DataQuery();

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname;
    }

    public String getBranchcode() {
        return branchcode;
    }

    public void setBranchcode(String branchcode) {
        this.branchcode = branchcode;
    }

    public String getAccnumber() {
        return accnumber;
    }

    public void setAccnumber(String accnumber) {
        this.accnumber = accnumber;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }
    
    public void add(){
        Bank b = new Bank(owner,bankname,branchcode,accnumber,iban);
        dataquery.addBank(b);
         FacesMessage message = new FacesMessage();
            message.setDetail("Başarili");
            message.setSummary("Banka Hesabı Başarıyla Eklendi.");
            message.setSeverity(FacesMessage.SEVERITY_INFO);
            FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
