/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.plagchecker.queries;

import com.mycompany.plagchecker.Model.Bank;
import com.mycompany.plagchecker.Model.Pricing;
import com.mycompany.plagchecker.Model.Report;
import com.mycompany.plagchecker.Model.Role;
import com.mycompany.plagchecker.Model.Settings;
import com.mycompany.plagchecker.Model.User;
import com.mycompany.plagchecker.Model.Contact;
import com.mycompany.plagchecker.Model.OrderPricing;
import java.io.Serializable;
import java.util.List;
import java.util.Properties;
import java.util.UUID;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 
/**
 *
 * @author Yusuf Can Çelik
 */
public class DataQuery implements Serializable {
    EntityManagerFactory emf;
    private EntityManager em;
    public DataQuery(){
      emf = Persistence.createEntityManagerFactory("plagcheckerUnit");
      em = emf.createEntityManager();
    }
   
   
    public User userlogincontrol(String username,String password){
        try{
           
       User u = em.createNamedQuery("Login.logincontrol",User.class).setParameter("username", username).setParameter("password", password).getSingleResult();
       em.refresh(u);
       return u;
        }catch(Exception e){
            e.printStackTrace();
        return null;
        } 
        
     
    }
 
    public List<User> getUsersByRole(String name){
       
        Role role = em.createNamedQuery("Role.FindByName",Role.class).setParameter("name",name).getSingleResult();
        em.refresh(role);
        return role.getUsers();
    }
    public boolean userfindByEmail(String email){
        try{
        User u = em.createNamedQuery("Users.FindByEmail",User.class).setParameter("email",email).getSingleResult();
        if(u != null){
            return false;
        }
        return true;
        }catch(Exception e){
            return true;
        }
    }
    public void removeUser(User us){
        em.getTransaction().begin();
        em.remove(us);
        em.getTransaction().commit();
    }
     public User userfindByEmaill(String email){
        try{
       User u = em.createNamedQuery("Users.FindByEmail",User.class).setParameter("email",email).getSingleResult();
        
        return u;
        }catch(Exception e){
            return null;
        }
    }
        
   public boolean userfindByUsername(String username){
       try{
       User u = em.createNamedQuery("Users.FindByUsername",User.class).setParameter("username",username).getSingleResult();
      if(u != null){
            return false;
        }
      
        return true;
        }catch(Exception e){
            return true;
        }
   }
   public List<Bank> getBanks(){
       return em.createNamedQuery("Banks.getAll",Bank.class).getResultList();
   }
   public void removeBank(Bank b){
            em.getTransaction().begin();
            em.remove(b);
            em.getTransaction().commit();
   
   }
    public User userfindById(Long id){
        try{
        User u = em.createNamedQuery("Users.FindByid",User.class).setParameter("userid",id).getSingleResult();
        if(u != null)
        return u;
        else
        return null;
    
        }catch(Exception e){
        return null;
        }
    }
    public Pricing pricingfindById(Long id){
         try{
        Pricing p = em.createNamedQuery("Pricing.FindByid",Pricing.class).setParameter("pricingid",id).getSingleResult();
        if(p != null)
        return p;
        else
        return null;
    
        }catch(Exception e){
        return null;
        }
    }
    public Integer creditLimit(Long user) {
       User u = em.createNamedQuery("Users.FindByid",User.class).setParameter("userid",user).getSingleResult();
        return u.getCredit_limit();
    }
    public void changeCreditLimit(User u){
        int s = u.getCredit_limit();
        em.getTransaction().begin();
        u.setCredit_limit(s);
        em.createNamedQuery("Users.updateCredit",User.class).setParameter("credit_limit",s).setParameter("userid", u.getUserid()).executeUpdate();
        em.getTransaction().commit();
        
    }
    public void updateUser(User user,Long id){
        User us = em.createNamedQuery("Users.FindByid",User.class).setParameter("userid",id).getSingleResult();
        em.getTransaction().begin();
        us.setEmail(user.getEmail());
        us.setUsername(user.getUsername());
        us.setFirstname(user.getFirstname());
        us.setLastname(user.getLastname());
        us.setPassword(user.getPassword());
        us.setCredit_limit(user.getCredit_limit());
        us.setIsenabled(user.isIsenabled());
        us.setTemporaryuuid(user.getTemporaryuuid());
        us.setRole(user.getRole());
        em.getTransaction().commit();
    }
    
    public void updatePricing(Pricing pricing,Long id){
        Pricing p = em.createNamedQuery("Pricing.FindByid", Pricing.class).setParameter("pricingid", id).getSingleResult();
        em.getTransaction().begin();
        p = pricing;
        em.getTransaction().commit();
    }
    public Role rolefindByName(String name){
       Role role = em.createNamedQuery("Role.FindByName",Role.class).setParameter("name",name).getSingleResult();
       return role; 
    }
    public void createUser(User u,String site,String rolename){

        Role role = em.createNamedQuery("Role.FindByName",Role.class).setParameter("name",rolename).getSingleResult();
        u.setRole(role);
        u.setTemporaryuuid(UUID.randomUUID().toString());
        em.getTransaction().begin();
        em.persist(u);        
        em.getTransaction().commit();   
        if(site != null){
        String mailcontent = "<h1>Hesabınızın aktifleştirilmesi için</h1></br> <a href=\""+site+"activation.xhtml?uuid="+u.getTemporaryuuid()+"\">linke</a> tıklayınız";
        sendMail("Hesabınızı Aktifleştirin",mailcontent,u.getEmail());
        }
    }
    public void createPricing(Pricing p){
        em.getTransaction().begin();
        em.persist(p);        
        em.getTransaction().commit();   
    }
    public boolean resetpassword(String uuid,String password){
        try{
               User user = em.createNamedQuery("Users.FindByUUID",User.class).setParameter("temporaryuuid", uuid).getSingleResult();
               if(user != null){
               em.getTransaction().begin();
               user.setPassword(password);
               user.setTemporaryuuid(UUID.randomUUID().toString());
               em.getTransaction().commit();
               return true;
               }
               System.err.println("hata");
               return false;
           }catch(Exception e){
               e.printStackTrace();
               return false;
           }
    }
        public boolean activationUser(String uuid){
           try{
               User u = em.createNamedQuery("Users.FindByUUID",User.class).setParameter("temporaryuuid", uuid).getSingleResult();
               if(u != null){
               em.getTransaction().begin();
               u.setIsenabled(true);
               u.setTemporaryuuid(UUID.randomUUID().toString());
               em.getTransaction().commit();
               return true;
               }
               return false;
           }catch(Exception e){
               return false;
           }
        }
        public void sendMail(String subject,String content,String email){
            String username = "yusufcancelik07@gmail.com";
            String password = "fb19077774";
            Properties properties = new Properties();
             properties.put("mail.smtp.auth", "true");
             properties.put("mail.smtp.starttls.enable", "true");
             properties.put("mail.smtp.host", "smtp.gmail.com");
             properties.put("mail.smtp.port", "587");
 
             Session session = Session.getInstance(properties,
               new javax.mail.Authenticator() 
               {
                   @Override
                   protected PasswordAuthentication getPasswordAuthentication() 
                   {
                        return new PasswordAuthentication(username, password);
                    }
                }); 
             try {
 
                    MimeMessage message = new MimeMessage(session);
                    message.setFrom(new InternetAddress("localhost@localhost8080.com"));
                    message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(email));
                    message.setSubject(subject);
                    message.setContent(content, "text/html; charset=utf-8");
                    Transport.send(message);
 
             } catch (Exception ex) {
                    throw new RuntimeException(ex);
             }
        }
        
        public List<Pricing> getAllPricing() {
          return em.createNamedQuery("Pricing.getAll",Pricing.class).getResultList();
        }
        
        public List<Report> getAllReport(){
          return em.createNamedQuery("Report.getAll",Report.class).getResultList();
        }
        public Report findReportById(Long id){
            try{
                Report r = em.createNamedQuery("Report.findById",Report.class).setParameter("reportid", id).getSingleResult();
                em.refresh(r);
                return r;
            }catch(Exception e){
                return null;
            }
        }
        public Settings findSettingsById(){
            try{
                Settings s = em.createNamedQuery("Settings.getSettings",Settings.class).setParameter("settingid", 1).getSingleResult();
                em.refresh(s);
                if(s == null){
                    s = new Settings();
                }
                return s;
            }catch(Exception e){
                Settings s = new Settings();
                 return s;
            }
        }
        
        public boolean updateSettings(Settings s){
            try{
                Settings setting = em.createNamedQuery("Settings.getSettings",Settings.class).setParameter("settingid", 1).getSingleResult();
                em.getTransaction().begin();
                setting = s;
                em.getTransaction().commit();
                return true;
            }catch(Exception e){
                return false;
            }
        }
        public void addReport(Report r){
           em.getTransaction().begin();
           em.persist(r);
           em.getTransaction().commit();
        }
        
        public List<Report> findReportsByUserId(User id){
          return em.createNamedQuery("Report.findByUserid",Report.class).setParameter("user", id).getResultList();
        }
        public void addContact(Contact c){
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
        }
        public List<Contact> getMessages(){
            return em.createNamedQuery("Message.getAll",Contact.class).getResultList();
        }
        public void removeMessage(Contact c){
            em.getTransaction().begin();
            em.remove(c);
            em.getTransaction().commit();
        }
        public Contact findMessageById(Long id){
         try{
                Contact c = em.createNamedQuery("Message.findById",Contact.class).setParameter("contactid", id).getSingleResult();
                em.refresh(c);
                return c;
            }catch(Exception e){
                return null;
            }
        }
        public void addOrder(OrderPricing o){
            em.getTransaction().begin();
            em.persist(o);
            em.getTransaction().commit();
        }
        public void addBank(Bank b){
            em.getTransaction().begin();
            em.persist(b);
            em.getTransaction().commit();
        }
}


