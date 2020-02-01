/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.assignment.mbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author stevechanvii
 */
@ManagedBean(name = "loginBean", eager = true)
@RequestScoped
public class LoginBean {
    private String email;
    private String type;
    private String password;
    
    public LoginBean() {
    }

    public LoginBean(String email, String type, String password) {
        this.email = email;
        this.type = type;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void login(){
        System.out.println("hello!!");
    }
    
}
