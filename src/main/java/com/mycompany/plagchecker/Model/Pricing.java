/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.plagchecker.Model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "pricing")
@NamedQueries({
    @NamedQuery(name="Pricing.getAll",query="select p from Pricing p"),
    @NamedQuery(name = "Pricing.FindByid",query="select p from Pricing p where p.pricingid = :pricingid"),
})
public class Pricing implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long pricingid;
    
    private int credit;
    
    private int price;
    
    private String firsttab;
    
    private String secondtab;
    
    private String thirdtab;
    
    private String fourthtab;

    public Pricing() {
    }

    public Pricing(int credit, int price, String firsttab, String secondtab, String thirdtab, String fourthtab) {
        this.credit = credit;
        this.price = price;
        this.firsttab = firsttab;
        this.secondtab = secondtab;
        this.thirdtab = thirdtab;
        this.fourthtab = fourthtab;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.pricingid);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pricing other = (Pricing) obj;
        if (!Objects.equals(this.pricingid, other.pricingid)) {
            return false;
        }
        return true;
    }
    
    
}
