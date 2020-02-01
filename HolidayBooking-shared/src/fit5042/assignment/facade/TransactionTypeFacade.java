/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.assignment.facade;

import fit5042.assignment.entity.TransactionType;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author stevechanvii
 */
@Remote
public interface TransactionTypeFacade {
    List<TransactionType> searchTransactionTypeByNO (int number) throws Exception;
    
    List<TransactionType> getAllTransactionType () throws Exception;
    
    public void createTransactionType(TransactionType transactionType) throws Exception;
}
