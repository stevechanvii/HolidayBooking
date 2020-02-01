/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.assignment.mbeans;

import fit5042.assignment.entity.Public;
import fit5042.assignment.entity.User;
import fit5042.assignment.facade.UserFacade;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author stevechanvii
 */
@ManagedBean(name = "editUserBean", eager = true)
@RequestScoped
public class EditUserBean {
    @EJB
    private UserFacade userFacade;
    
    private int userID;
    private String firstName;
    private String lastName;
    private String type;
    private String email;
    private String password;
    private String street;
    private String suburb;
    private String state;
    private int postcode;
    private int phone;
    
    @ManagedProperty(value = "#{sessionController.email}")
    private String loginEmail;

    public EditUserBean() {
//        System.out.println("aavvc" + loginEmail);
//        Public user = userFacade.getUserByEmail(loginEmail).get(0);
//        this.firstName = user.getFirstName();
//        this.lastName = user.getLastName();
//        this.email = user.getEmail();
//        this.password = user.getPassword();
//        this.street = user.getAddress().getStreet();
//        this.suburb = user.getAddress().getSuburb();
//        this.state = user.getAddress().getState();
//        this.postcode = user.getAddress().getPostcode() + "";
//        this.phone = user.getPhone();
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getLoginEmail() {
        return loginEmail;
    }

    public void setLoginEmail(String loginEmail) {
        this.loginEmail = loginEmail;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void initValues(){
        System.out.println(loginEmail + "helllll");
        System.out.println("aavvc" + loginEmail);
        User user = userFacade.getUserByEmail(loginEmail).get(0);
        
        this.userID = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
//        this.password = user.getPassword();
        this.street = user.getAddress().getStreet();
        this.suburb = user.getAddress().getSuburb();
        this.state = user.getAddress().getState();
        this.postcode = user.getAddress().getPostcode();
        this.phone = user.getPhone();
        System.out.println(firstName + lastName + " bbbbb " + userID);
    }
    
    
    public void update(){
        System.out.println(firstName + lastName + "aaaaaa" + userID);
        userFacade.update(userID, firstName, lastName, email, street, suburb, state, postcode);
    }
}
