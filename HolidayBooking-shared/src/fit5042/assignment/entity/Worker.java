/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.assignment.entity;

import javax.persistence.Entity;

/**
 *
 * @author stevechanvii
 */
@Entity
public class Worker extends User{

    public Worker() {
    }

    public Worker(String firstName, String lastName, String email, String password, Address address, int phone) {
        super(firstName, lastName, email, password, address, phone);
    }
    
}
