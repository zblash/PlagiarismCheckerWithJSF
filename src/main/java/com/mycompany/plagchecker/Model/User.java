package com.mycompany.plagchecker.Model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name="user")
@NamedQueries({
    @NamedQuery(name = "Users.alls",query="select u from User u"),
    @NamedQuery(name = "Users.FindByUsername",query="select u from User u where u.username = :username"),
    @NamedQuery(name = "Users.FindByEmail",query="select u from User u where u.email = :email"),
    @NamedQuery(name = "Users.FindByid",query="select u from User u where u.userid = :userid"),
    @NamedQuery(name = "Users.updateCredit",query="UPDATE User u SET u.credit_limit= :credit_limit WHERE u.userid = :userid"),
    @NamedQuery(name = "Users.updateEnable",query="UPDATE User u SET u.isenabled= :isenabled WHERE u.userid = :userid"),
    @NamedQuery(name = "Users.FindByUUID",query="select u from User u where u.temporaryuuid = :temporaryuuid"),
    @NamedQuery(name = "Login.logincontrol",query = "select u from User u where u.username = :username and u.password = :password")
})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long userid;
    
    @Column(unique=true)
    private String email;
    
    @Column(unique=true)
    private String username;
    
    private String firstname;
    
    private String lastname;
    
    private String password;
    
    private Integer credit_limit;
    
    private boolean isenabled;
    
    private String temporaryuuid;


    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinTable(name="user_role",joinColumns = @JoinColumn(name = "user_id"), 
                            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Role role; 

    public User() {
    }

    public User(String email, String username, String firstname, String lastname, String password, Integer credit_limit) {
        this.email = email;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.credit_limit = credit_limit;
    
    }


    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getCredit_limit() {
        return credit_limit;
    }

    public void setCredit_limit(Integer credit_limit) {
        this.credit_limit = credit_limit;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    public boolean isIsenabled() {
        return isenabled;
    }

    public void setIsenabled(boolean isenabled) {
        this.isenabled = isenabled;
    }

    public String getTemporaryuuid() {
        return temporaryuuid;
    }

    public void setTemporaryuuid(String temporaryuuid) {
        this.temporaryuuid = temporaryuuid;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.userid);
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
        final User other = (User) obj;
        if (!Objects.equals(this.userid, other.userid)) {
            return false;
        }
        return true;
    }


}
