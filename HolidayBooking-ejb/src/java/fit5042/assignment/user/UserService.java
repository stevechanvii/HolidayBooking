/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.assignment.user;

import fit5042.assignment.entity.Public;
import fit5042.assignment.entity.User;
import fit5042.assignment.facade.UserFacade;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author stevechanvii
 */
@Stateless
public class UserService implements UserFacade{

    @PersistenceContext(unitName = "HolidayBooking-warPU")
    private EntityManager em;
    
    @Override
    public void createUser(User user) {
        em.persist(user);
    }

    @Override
    public List<User> getAllUser() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> u = cq.from(User.class);
        
        cq.select(u);
        TypedQuery<User> tq = em.createQuery(cq);
        return tq.getResultList();
    }

    @Override
    public List<User> getUser(String query) {
        return em.createQuery(query, User.class).getResultList();
    }

    @Override
    public int deleteUser(int userID) {
        int count = 0;
        
        try{
            User userEntity = em.merge(getUser(userID).get(0));
            em.remove(userEntity);
            
//            Query query = em.createQuery("delete from User u where u.id = " + userID);
//            count = query.executeUpdate();
        } catch(Exception e){
            System.out.println(e);
            count = -1;
        }
        return count;
    }

    @Override
    public List<User> getUser(int id) {
        String query = "select u from User u where u.id = " + id;
        return em.createQuery(query, User.class).getResultList();
    }

    @Override
    public List<Public> getUserByEmail(String email) {
        String query = "select u from User u where u.email = '" + email + "'";
        return em.createQuery(query, Public.class).getResultList();
    }

    @Override
    public void update(int id, String firstName, String lastName, String email, String street, String suburb, String state, int postcode) {
        Query q = em.createQuery("update User u set u.firstName = '" + firstName + "', u.lastName = '" + lastName + "', "
                + "u.email = '" + email + "', u.address.street = '" + street + "', u.address.suburb = '" + suburb + "',"
                + " u.address.state = '" + state + "', u.address.postcode = " + postcode + " where u.id = " + id);
        q.executeUpdate();
    }
    
}
