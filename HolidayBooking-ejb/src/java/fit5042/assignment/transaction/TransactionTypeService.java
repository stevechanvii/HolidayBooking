/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.assignment.transaction;

import fit5042.assignment.entity.TransactionType;
import fit5042.assignment.facade.TransactionTypeFacade;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author stevechanvii
 */
@Stateless
public class TransactionTypeService implements TransactionTypeFacade{

    @PersistenceContext(unitName = "HolidayBooking-warPU")
    private EntityManager em;
    
    @Override
    public List<TransactionType> searchTransactionTypeByNO(int number) throws Exception {
        return em.createQuery("select t from TransactionType t where t.typeID = " + number).getResultList();
    }

    @Override
    public void createTransactionType(TransactionType transactionType) throws Exception {
        em.persist(transactionType);
    }

    @Override
    public List<TransactionType> getAllTransactionType() throws Exception {
        return em.createQuery("select t from TransactionType t").getResultList();
    }
    
}
