/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.assignment.facade;

import fit5042.assignment.entity.Public;
import fit5042.assignment.entity.User;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author stevechanvii
 */
@Remote
public interface UserFacade {
    public void createUser(User user);
    
    public List<User> getAllUser();
    
    public List<User> getUser(String query);
    
    public List<User> getUser(int id);
    
    public int deleteUser(int userID);
    
    public List<Public> getUserByEmail(String email);
    
    public void update(int id, String firstName, String lastName, String email, String street, String suburb, String state, int postcode);
}
