package fit5042.assignment.entity;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author stevechanvii
 */
@Entity
public class TransactionType implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int typeID;
    private String typeName;
    @ManyToMany(mappedBy = "transactionType")
    private List<Transactions> transaction;

    public TransactionType() {
    }

    public TransactionType(int typeID, String typeName, List<Transactions> transaction) {
        this.typeID = typeID;
        this.typeName = typeName;
        this.transaction = transaction;
    }

    public TransactionType(String typeName) {
        this.typeName = typeName;
    }

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public List<Transactions> getTransaction() {
        return transaction;
    }

    public void setTransaction(List<Transactions> transaction) {
        this.transaction = transaction;
    }

    
    
    
}
