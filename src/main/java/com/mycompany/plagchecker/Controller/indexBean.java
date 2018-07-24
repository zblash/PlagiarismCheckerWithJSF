/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.plagchecker.Controller;

import com.mycompany.plagchecker.Model.Settings;
import com.mycompany.plagchecker.queries.DataQuery;
import java.io.IOException;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

@ManagedBean(name = "indexBean")
@SessionScoped
public class indexBean implements Serializable {
   private String title;
   private String keywords;
   private String description;
   private String author;
   private String facebook;
   private String twitter;
   private Settings s;
   private DataQuery dataquery = new DataQuery();
   @PostConstruct
   public void init(){
       s = dataquery.findSettingsById();
       title = s.getTitle();
       keywords = s.getKeywords();
       description = s.getDescription();
       author = s.getAuthor();
       facebook = s.getFacebook();
       twitter = s.getTwitter();
       
   }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }
   
   
}
