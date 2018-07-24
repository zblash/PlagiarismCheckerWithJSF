/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.plagchecker.Controller.AdminController;

import com.mycompany.plagchecker.Model.User;
import com.mycompany.plagchecker.queries.DataQuery;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name="employeeindexBean")
@ViewScoped
public class EmployeeIndexBean {
    private List<User> users;
    private List<User> filteredUsers;
    private DataQuery dataquery = new DataQuery();
    private User selectedRow;

    
    @PostConstruct
    public void init(){
    users = dataquery.getUsersByRole("admin");
    }
    
    public User getSelectedRow() {
        return selectedRow;
    }

    public void setSelectedRow(User selectedRow) {
        this.selectedRow = selectedRow;
    }

    public List<User> getUsers() {
        return users;
    }
    
    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<User> getFilteredUsers() {
        return filteredUsers;
    }

    public void setFilteredUsers(List<User> filteredUsers) {
        this.filteredUsers = filteredUsers;
    }
    
    public void removeUser(){
    users.remove(selectedRow);
    dataquery.removeUser(selectedRow);
    selectedRow=null;
    }
}
