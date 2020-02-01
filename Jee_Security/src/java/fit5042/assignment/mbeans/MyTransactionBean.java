/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.assignment.mbeans;

import fit5042.assignment.entity.Public;
import fit5042.assignment.entity.Transactions;
import fit5042.assignment.facade.TransactionFacade;
import fit5042.assignment.facade.UserFacade;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author stevechanvii
 */
@ManagedBean(name = "myTransactionBean", eager = true)
@ViewScoped
public class MyTransactionBean {

    @EJB
    private TransactionFacade transactionFacade;
    @EJB
    private UserFacade userFacade;

    private String name;
    List<Transactions> transactions = null;

    public MyTransactionBean() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Transactions> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transactions> transactions) {
        this.transactions = transactions;
    }

    public void search() {
        Public user = userFacade.getUserByEmail(getParameter("userEmail")).get(0);
        try {
            transactions = transactionFacade.searchTransactionByUser(user);
        } catch (Exception ex) {
            Logger.getLogger(MyTransactionBean.class.getName()).log(Level.SEVERE, null, ex);
        }
//        if (name != null && !name.isEmpty()) {
//            System.out.println("aab " + name);
//            transactions.removeIf(s -> s.getTransactionName().equals(name));
//            System.out.println("aab " + transactions.size());
//            name = null;
//        }

    }

    public String getParameter(String key) {
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
        return params.get(key);
    }

    @PostConstruct
    public void deleteUser() {
        System.out.println("delete trabsaction");
        String data = getParameter("transactionNO");
        if (data != null && !data.isEmpty()) {
            try {
                System.out.println(data);
                transactionFacade.deleteTransactionByNo(Integer.parseInt(data));
            } catch (Exception ex) {
                Logger.getLogger(MyTransactionBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
