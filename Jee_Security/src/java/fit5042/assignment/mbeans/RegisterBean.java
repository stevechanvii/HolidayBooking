/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.assignment.mbeans;

import fit5042.assignment.entity.Address;
import fit5042.assignment.entity.Public;
import fit5042.assignment.entity.User;
import fit5042.assignment.entity.Worker;
import fit5042.assignment.facade.UserFacade;
import fit5042.assignment.util.HashString;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author stevechanvii
 */
@ManagedBean(name = "registerBean", eager = true)
@RequestScoped
public class RegisterBean {
    @EJB
    private UserFacade userFacade;
    
    private String firstName;
    private String lastName;
    private String type;
    private String email;
    private String password;
    private String street;
    private String suburb;
    private String state;
    private String postcode;
    private int phone;

    public RegisterBean() {
    }

    public RegisterBean(String firstName, String lastName, String email, String password, String street, String suburb, String state, String postcode, int phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.street = street;
        this.suburb = suburb;
        this.state = state;
        this.postcode = postcode;
        this.phone = phone;
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

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public void createUser() throws NoSuchAlgorithmException{
        HashString hs = new HashString();
        String passwordHash = hs.hash(password);
        Address address = new Address(street, suburb, state, Integer.parseInt(postcode));
        User u;
        if (type.equals("Public"))
            u = new Public(firstName, lastName, email, passwordHash, address, phone);
        else
            u = new Worker(firstName, lastName, email, passwordHash, address, phone);
        userFacade.createUser(u);
    }
    
    
}
