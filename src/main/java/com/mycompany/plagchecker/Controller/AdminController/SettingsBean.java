/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.plagchecker.Controller.AdminController;

import com.mycompany.plagchecker.queries.DataQuery;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.mycompany.plagchecker.Model.Settings;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;


@ManagedBean(name="adminsettingsBean")
@ViewScoped
public class SettingsBean {
    private String title;
    private List<String> keywords;
    private String description;
    private String author;
    private String facebook;
    private String twitter;
    private String googlekey;
    private Settings s;
    private DataQuery dataquery = new DataQuery();
    private Part file;
    private StringBuilder keywordlist = new StringBuilder();
    
    @PostConstruct
    public void init(){
        s = dataquery.findSettingsById();
        String keyword = s.getKeywords();
        description = s.getDescription();
        author = s.getAuthor();
        facebook = s.getFacebook();
        twitter = s.getTwitter();
        googlekey = s.getGooglekey();
        keywords = new ArrayList<>(Arrays.asList(keyword.split(",")));
        
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
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

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

    public void edit() throws IOException{
        
        for(int i = 0;i<keywords.size();i++){
            if(i+1 == keywords.size()){
            keywordlist.append(keywords.get(i));
            }else{
            keywordlist.append(keywords.get(i)+",");
            }
        }
        if(file != null) {
        InputStream fileInputStream = file.getInputStream();
        byte[] buffer = new byte[(int) file.getSize()];
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        for(int length = 0;(length = fileInputStream.read(buffer))>0;){
            output.write(buffer, 0, length);
        }
        s.setImage(output.toByteArray());
        }
        s.setTitle(title);
        s.setKeywords(keywordlist.toString());
        s.setDescription(description);
        s.setAuthor(author);
        s.setFacebook(facebook);
        s.setTwitter(twitter);
        s.setGooglekey(googlekey);
        keywordlist.setLength(0);
        if(dataquery.updateSettings(s)){
            FacesMessage message = new FacesMessage();
            message.setDetail("Basarili");
            message.setSummary("Site Ayarları Güncellendi.");
            message.setSeverity(FacesMessage.SEVERITY_INFO);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }else{
            FacesMessage message = new FacesMessage();
            message.setDetail("Başarisiz");
            message.setSummary("İşlem Sırasında Bir Hata Oluştu.");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        
    }
     public void upload() throws IOException {  
        byte[] picInBytes = new byte[(int) file.getSize()];
        FileInputStream fileInputStream = (FileInputStream) file.getInputStream();
        fileInputStream.read(picInBytes);
        fileInputStream.close();
         System.out.println(picInBytes);

    }  
   
}
