/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.assignment.transaction;

import fit5042.assignment.entity.Public;
import fit5042.assignment.entity.Transactions;
import fit5042.assignment.entity.User;
import fit5042.assignment.facade.TransactionFacade;
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
public class TransactionService implements TransactionFacade{
    
    @PersistenceContext(unitName = "HolidayBooking-warPU")
    private EntityManager em;

    public TransactionService() {
    }
    
    @Override
    public List<Transactions> getAllTransactions() throws Exception {
        return em.createQuery("select t from Transactions t", Transactions.class).getResultList();
    }

    @Override
    public List<Transactions> searchTransactionByName(String name) throws Exception {
        return em.createQuery("select t from Transactions t where t.transactionName = '" + name + "'").getResultList();
    }

    @Override
    public List<Transactions> searchTransactionByType(String type) throws Exception { // problems!
        return em.createQuery("select t from Transactions t join t.transactionType tt where tt.typeName = '" + type + "'").getResultList();
    }

    @Override
    public void createTransaction(Transactions transaction) throws Exception {
        em.persist(transaction);
    }

    @Override
    public List<Transactions> searchTransactionByNO(int number) throws Exception {
        return em.createQuery("select t from Transactions t where t.transactionNO = " + number).getResultList();
    }

    @Override
    public List<Object[]> searchPartialTransactionByNO(int number) throws Exception {
        return em.createQuery("select t.transactionNO, t.transactionName from Transactions t where t.transactionNO = " + number).getResultList();
    }

    @Override
    public List<Object[]> searchTransactionByUser(String email) throws Exception {
        return em.createQuery("select t.transactionNO, t.transactionName, t.description from Transactions t join t.user u where u.email = '" + email + "'").getResultList();
    }

    @Override
    public List<Transactions> searchTransactionByUser(Public user) throws Exception {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Transactions> cq = cb.createQuery(Transactions.class);
        Root<Transactions> t = cq.from(Transactions.class);
        
        cq.select(t).where(cb.equal(t.get("user"), user));
        TypedQuery<Transactions> tq = em.createQuery(cq);
        return tq.getResultList();
//        return em.createQuery("select t from Transactions t where t.user = " + user).getResultList();
    }

    @Override
    public void deleteTransactionByNo(int transactionNo) throws Exception {
        Query query = em.createQuery("delete from Transactions t where t.transactionNO = " + transactionNo);
        query.executeUpdate();
    }

    @Override
    public void updateTransactionState(int transactionNo) throws Exception {
        Query query = em.createQuery("update Transactions t set t.checked = 1 where t.transactionNO = " + transactionNo);
        query.executeUpdate();
    }
}
