/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.plagchecker.Controller;

import com.mycompany.plagchecker.Model.PlagiarismChecker;
import com.mycompany.plagchecker.Model.Report;
import com.mycompany.plagchecker.Model.User;
import com.mycompany.plagchecker.queries.DataQuery;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.event.FileUploadEvent;

/**
 *
 * @author Yusuf Can Çelik
 */
@ManagedBean(name = "plagiarismCheckerBean")
@ViewScoped
public class PlagiarismCheckerBean implements Serializable {
    private int resultpercent;
    private Integer loadpercent;
    private String article="";
    private String title;
    private boolean preresultbool = false;
    private boolean resultbool = false;
    private PlagiarismChecker plagcheck = new PlagiarismChecker();
    private final DataQuery dataquery = new DataQuery();
    private Report r;
    public boolean isPreresultbool() {
        return preresultbool;
    }

    public void setPreresultbool(boolean preresultbool) {
        this.preresultbool = preresultbool;
    }

    public boolean isResultbool() {
        return resultbool;
    }

    public void setResultbool(boolean resultbool) {
        this.resultbool = resultbool;
    }
    
    public int getResultpercent() {
        return resultpercent;
    }

    public Integer getLoadpercent() {
       
        return loadpercent;
    }

    public void setLoadpercent(Integer loadpercent) {
        this.loadpercent = loadpercent;
    }

    public void setResultpercent(int resultpercent) {
        this.resultpercent = resultpercent;
    }
   
    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
        public void handleFileUpload(FileUploadEvent event) throws IOException {
            char c;
            int i;
            StringBuilder st = new StringBuilder();
            
           InputStream input = event.getFile().getInputstream();
            while((i = input.read())!=-1) {
            c = (char)i;
            st.append(c);
         }
           
        article = st.toString();
    }
    public void checker() throws Exception{
       HttpSession sess = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
       User user = (User)sess.getAttribute("user");
       if(user.getCredit_limit() > 0){
           if(article.length() <= 1000){
       resultpercent = 0;
       ArrayList<String> articlelist = new ArrayList<>(Arrays.asList(article.split(" ")));
       ArrayList<String> wordlist = plagcheck.searchwords(articlelist, 0);
       for(int i = 0;i< wordlist.size();i++){
           loadpercent = ((i+1)*100)/wordlist.size();
           resultpercent += plagcheck.splitwords(wordlist.get(i), 0);
       }
       resultpercent = (resultpercent * 100)/ wordlist.size();
       int s = user.getCredit_limit()-1;
       user.setCredit_limit(s);
       sess.setAttribute("user", user);
       dataquery.changeCreditLimit(user);
       Date date = new Date();
       r = new Report(title,article,article.length(),resultpercent,date);
       r.setUser(user);
       dataquery.addReport(r);
       
           }else{
            FacesMessage message = new FacesMessage();
            message.setDetail("Lütfen Makalenizi Düzenleyin");
            message.setSummary("Maksimum 1000 Karakter İçerebilir");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage(null, message);
           }
    }else{
            FacesMessage message = new FacesMessage();
            message.setDetail("Yetersiz Bakiye");
            message.setSummary("Yetersiz Bakiye");
            message.setSeverity(FacesMessage.SEVERITY_INFO);
            FacesContext.getCurrentInstance().addMessage(null, message);
       }
    }
}
