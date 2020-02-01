/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.assignment.mbeans;

import fit5042.assignment.entity.User;
import fit5042.assignment.facade.UserFacade;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author stevechanvii
 */
@ManagedBean(name = "userManagementBean", eager = true)
@ViewScoped
public class UserManagementBean {
    @EJB
    private UserFacade userFacade;
    
    private String userId;
    private String firstName;
    private String lastName;
    private String type = "Public";
    private String email;
    private int userNumber;
    private List<User> userList;

    public UserManagementBean() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public int getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(int userNumber) {
        this.userNumber = userNumber;
    }
    
    public void searchUser(){
        String query;
        
        if (type.equals("Public"))
            query = "select u from User u where TYPE(u) = Public";
        else
            query = "select u from User u where TYPE(u) = Worker";
        
        if (userId != null && !userId.isEmpty())
            query += " and u.id = " + userId;
        
        if (firstName != null && !firstName.isEmpty())
            query += " and u.firstName = '" + firstName + "'";
        
        if (lastName != null && !lastName.isEmpty())
            query += " and u.lastName = '" + lastName + "'";
        
        if (email != null && !email.isEmpty())
            query += " and u.email = '" + email + "'";

//        userList = userFacade.deleteUser(1);
        userList = userFacade.getUser(query);
    }
    
    @PostConstruct
    public void deleteUser(){
        System.out.println("delete user");
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
        String data =  params.get("userID"); 
        if (data != null && !data.isEmpty()){
            System.out.println(data);
            int recordsDel = userFacade.deleteUser(Integer.parseInt(data));
            System.out.println(recordsDel);
        }
            
    }
    
    public String modifyUser(){
        System.out.println("edit user");
        return "editUser";
    }
}
