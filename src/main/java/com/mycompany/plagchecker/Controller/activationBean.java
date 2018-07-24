/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.plagchecker.Controller;

import com.mycompany.plagchecker.queries.DataQuery;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="activationBean")
@RequestScoped
public class activationBean implements Serializable  {
    @ManagedProperty(value="#{param.uuid}")
    private String uuid;
    
    private boolean valid;
    
    private DataQuery dataquery = new DataQuery();
    
    @PostConstruct
    public void init() {
       valid = dataquery.activationUser(uuid);
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }
    
}
