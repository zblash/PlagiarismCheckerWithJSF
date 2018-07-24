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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="settings")
@NamedQueries({
    @NamedQuery(name="Settings.getSettings",query="select s from Settings s where s.settingid = :settingid")
})
public class Settings implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long settingid;
    
    private String title;
    
    private String keywords;
    
    private String description;
    
    private String author;
    
    private String facebook;
    
    private String twitter;

    private String googlekey;
    
    @Lob
    @Column(name="image")
    private byte[] image;
    
    public Settings() {
    }

    public Settings(String keywords, String description, String author, String facebook, String twitter) {
        this.keywords = keywords;
        this.description = description;
        this.author = author;
        this.facebook = facebook;
        this.twitter = twitter;
    }

    public Long getSettingid() {
        return settingid;
    }

    public void setSettingid(Long settingid) {
        this.settingid = settingid;
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

    public String getGooglekey() {
        return googlekey;
    }

    public void setGooglekey(String googlekey) {
        this.googlekey = googlekey;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.settingid);
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
        final Settings other = (Settings) obj;
        if (!Objects.equals(this.settingid, other.settingid)) {
            return false;
        }
        return true;
    }
    
}
