/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.assignment.mbeans;

import fit5042.assignment.entity.TransactionType;
import fit5042.assignment.facade.TransactionTypeFacade;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author stevechanvii
 */
@ManagedBean(name = "transactionTypeBean", eager = true)
@RequestScoped
public class TransactionTypeBean {
    @EJB
    private TransactionTypeFacade transactionTypeFacade;
    private List<TransactionType> transactionType;

    public TransactionTypeBean() {

    }

    public List<TransactionType> getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(List<TransactionType> transactionType) {
        this.transactionType = transactionType;
    }
    
    
    
    
    
}
