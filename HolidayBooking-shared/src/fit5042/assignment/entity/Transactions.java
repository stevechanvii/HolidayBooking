package fit5042.assignment.entity;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author stevechanvii
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "findAll", query = "select t from Transactions t")
    ,
    @NamedQuery(name = "findByName", query = "select t from Transactions t where t.transactionName = :input")
    ,
    @NamedQuery(name = "findByNumber", query = "select t from Transactions t where t.transactionNO = :input")
    ,
    @NamedQuery(name = "findByType", query = "select t from Transactions t where t.transactionType = :input")
})
public class Transactions implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionNO;
    private String transactionName;
    private String description;
    private Boolean checked = false;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "trans_type", joinColumns = @JoinColumn(name = "transaction_fk"), 
            inverseJoinColumns = @JoinColumn(name = "transaction_type_fk"))
    private List<TransactionType> transactionType;

    @ManyToOne
    @JoinColumn(name = "public_fk")
    private Public user;
    
    public Transactions() {
    }

    public Transactions(int transactionNO, String transactionName) {
        this.transactionNO = transactionNO;
        this.transactionName = transactionName;
    }

    public Transactions(int transactionNO, String transactionName, String description) {
        this.transactionNO = transactionNO;
        this.transactionName = transactionName;
        this.description = description;
    }

    public Transactions(String transactionName, String description, List<TransactionType> transactionType) {
        this.transactionName = transactionName;
        this.description = description;
        this.transactionType = transactionType;
    }

    public Transactions(String transactionName, String description, List<TransactionType> transactionType, Public user) {
        this.transactionName = transactionName;
        this.description = description;
        this.transactionType = transactionType;
        this.user = user;
    }

    
    public int getTransactionNO() {
        return transactionNO;
    }

    public void setTransactionNO(int transactionNO) {
        this.transactionNO = transactionNO;
    }

    public String getTransactionName() {
        return transactionName;
    }

    public void setTransactionName(String transactionName) {
        this.transactionName = transactionName;
    }

    public List<TransactionType> getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(List<TransactionType> transactionType) {
        this.transactionType = transactionType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Public getUser() {
        return user;
    }

    public void setUser(Public user) {
        this.user = user;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    
 

}
