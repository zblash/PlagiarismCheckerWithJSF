/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.plagchecker.Controller.AdminController;

import com.mycompany.plagchecker.Model.Report;
import com.mycompany.plagchecker.queries.DataQuery;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name="adminreportindexBean")
@ViewScoped
public class ReportIndexBean implements Serializable {
    private List<Report> reports;
    private List<Report> filteredReports;
    private DataQuery dataquery = new DataQuery();

    @PostConstruct
    public void init(){
    reports = dataquery.getAllReport();
        for (int i = 0; i < reports.size(); i++) {
            System.out.println(reports.get(i).getDate());
        }
    }
    
    public List<Report> getReports() {
        return reports;
    }

    public void setReports(List<Report> reports) {
        this.reports = reports;
    }

    public List<Report> getFilteredReports() {
        return filteredReports;
    }

    public void setFilteredReports(List<Report> filteredReports) {
        this.filteredReports = filteredReports;
    }
    
}
