/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.assignment.facade;

import fit5042.assignment.entity.Public;
import fit5042.assignment.entity.Transactions;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author stevechanvii
 */
@Remote
public interface TransactionFacade {
    
    public List<Transactions> getAllTransactions() throws Exception;
    
    public List<Transactions> searchTransactionByNO (int number) throws Exception;
    
    public List<Object[]> searchPartialTransactionByNO (int number) throws Exception;
    
    public List<Transactions> searchTransactionByName (String name) throws Exception;
    
    public List<Transactions> searchTransactionByType (String type) throws Exception;
    
    public void createTransaction(Transactions transaction) throws Exception;
    
    public List<Object[]> searchTransactionByUser(String email) throws Exception;
    
    public List<Transactions> searchTransactionByUser (Public user) throws Exception;
    
    public void deleteTransactionByNo(int transactionNo) throws Exception;
    
    public void updateTransactionState(int transactionNo) throws Exception;
}
