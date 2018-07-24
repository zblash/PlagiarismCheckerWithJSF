/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.plagchecker.Controller.AdminController;

import com.mycompany.plagchecker.Model.Contact;
import com.mycompany.plagchecker.queries.DataQuery;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name="adminmessagesindexBean")
@ViewScoped
public class MessagesIndexBean implements Serializable{
    private List<Contact> messages;
    private List<Contact> filteredMessages;
    private Contact selectedRow;
    private DataQuery dataquery = new DataQuery();
    private Contact c = new Contact();

    @PostConstruct
    public void init(){
    messages = dataquery.getMessages();
    }

    public List<Contact> getMessages() {
        return messages;
    }

    public void setMessages(List<Contact> messages) {
        this.messages = messages;
    }

    public List<Contact> getFilteredMessages() {
        return filteredMessages;
    }

    public void setFilteredMessages(List<Contact> filteredMessages) {
        this.filteredMessages = filteredMessages;
    }

    public Contact getSelectedRow() {
        return selectedRow;
    }

    public void setSelectedRow(Contact selectedRow) {
        this.selectedRow = selectedRow;
    }
    public void removeMes(){
    messages.remove(selectedRow);
    dataquery.removeMessage(selectedRow);
    selectedRow=null;
    }
}
