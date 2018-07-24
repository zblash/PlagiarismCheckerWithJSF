/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.plagchecker.Controller.AdminController;

import com.mycompany.plagchecker.Model.Report;
import com.mycompany.plagchecker.queries.DataQuery;
import java.util.Date;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name="adminreportcontentBean")
@ViewScoped
public class ReportContentBean {
    
    private String title;
    private String content;
    private String username;
    private int words;
    private int plagiarism;
    private Date date;
    private Long id;
    private Report r;
    private DataQuery dataquery = new DataQuery();
    
    
    public void init(){
        String value = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("reportid");
        FacesContext fc = FacesContext.getCurrentInstance();
        ConfigurableNavigationHandler nav = (ConfigurableNavigationHandler) fc.getApplication().getNavigationHandler();
        try{
            id = Long.parseLong(value);
            r = dataquery.findReportById(id);
            title = r.getTitle();
            content = r.getContent();
            username = r.getUser().getUsername();
            words = r.getWords();
            plagiarism = r.getPlagiarism();
            date = r.getDate();

        }catch(Exception e){
                    System.out.println("hata yusuf");
                    nav.performNavigation("/admin/reportindex.xhtml?faces-redirect=true");
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getWords() {
        return words;
    }

    public void setWords(int words) {
        this.words = words;
    }

    public int getPlagiarism() {
        return plagiarism;
    }

    public void setPlagiarism(int plagiarism) {
        this.plagiarism = plagiarism;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Report getR() {
        return r;
    }

    public void setR(Report r) {
        this.r = r;
    }
        
         
    
}
