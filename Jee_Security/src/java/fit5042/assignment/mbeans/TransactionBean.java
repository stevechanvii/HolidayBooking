/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.assignment.mbeans;

import fit5042.assignment.entity.TransactionType;
import fit5042.assignment.entity.Transactions;
import fit5042.assignment.facade.TransactionFacade;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author stevechanvii
 */
@ManagedBean(name = "transactionBean", eager = true)
@RequestScoped
public class TransactionBean {

    @EJB
    private TransactionFacade transactionFacade;

    private String option;
    private String input;
    private String showAll;
    
    private String t;

    List<Transactions> transactions = null;

    public List<Transactions> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transactions> transactions) {
        this.transactions = transactions;
    }

    public TransactionBean() {
    }

    public String getShowAll() {
        return showAll;
    }

    public void setShowAll(String showAll) {
        this.showAll = showAll;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getT() {
        return t;
    }

    public void setT(String t) {
        this.t = t;
    }
    

    public void searchTransaction() {
//        String searchJPQL = "findBy" + option;
//        System.out.println("hello bokking " + option + " " + input);
//        Query query = em.createNamedQuery(searchJPQL).setParameter("input", input);

//        Transactions t = new Transactions();
//        t.setTransactionNO(2);
//        t.setTransactionName("Room Booking");
//        t.setDescription("Customer: Steve \n Booking date: 3-Sep-2018");
//        List<Transactions> lt = new ArrayList<>();
//        lt.add(t);
//        TransactionType tt = new TransactionType();
//        List<TransactionType> ltt = new ArrayList<>();
//        t.setTransactionType(ltt);
//        ltt.add(tt);
//        tt.setTypeID(1);
//        tt.setTypeName("Cash");
//        tt.setTransaction(lt);
//        try {
//            transactionFacade.createTransaction(t);
//        } catch (Exception ex) {
//            Logger.getLogger(TransactionBean.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        List<Transactions> transactions = null;
  /*      System.out.println("gggggg " + Boolean.parseBoolean(showAll));
        if (!Boolean.parseBoolean(showAll)) {
            switch (option) {
                case "Number": {
                    try {
                        transactions = new ArrayList<>();
                        System.out.println("fffff " + Boolean.parseBoolean(showAll));
//                        transactions.add(new Transactions(1, "haha"));
                        for(Object[] obj : transactionFacade.searchPartialTransactionByNO(Integer.parseInt(input))){
                            System.out.println("hhhhh ddd" + obj[0] + obj[1]);
                            
                            transactions.add(new Transactions((int)obj[0], (String) obj[1]));
                        }
                    } catch (Exception ex) {
                        System.out.println("hhhhh " + Boolean.parseBoolean(showAll));
                        Logger.getLogger(TransactionBean.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        } else {
            switch (option) {
                case "Number":
                    try {
                        transactions = transactionFacade.searchTransactionByNO(Integer.parseInt(input));
                        System.out.println("heeee " + transactions.get(0).getTransactionType().isEmpty());
                    } catch (Exception ex) {
                        Logger.getLogger(TransactionBean.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case "Name":
                    try {
                        transactions = transactionFacade.searchTransactionByName(input);
                    } catch (Exception ex) {
                        Logger.getLogger(TransactionBean.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;

                case "Type":
                    try {
                        transactions = transactionFacade.searchTransactionByType(input);
                    } catch (Exception ex) {
                        Logger.getLogger(TransactionBean.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
            }
        } */
        switch (option) {
                case "Number":
                    try {
                        transactions = transactionFacade.searchTransactionByNO(Integer.parseInt(input));
                        t = "";
                        int count = 0;
                        for (Transactions tr: transactions){
                            String tt = "";
                            for (TransactionType tp: tr.getTransactionType()){
                                tt += tp.getTypeName() + " ";
                            }
                            t += "{\"no\":" + tr.getTransactionNO() + ",\"name\":\"" + tr.getTransactionName() + 
                                    "\",\"type\":\"" + tt + "\",\"description\":\"" +  tr.getDescription() + "\"}";
                            count += 1;
                            if (transactions.size() != count){
                                t += ";";
                            }
                        }
                        System.out.println("heeee " + transactions.get(0).getTransactionType().isEmpty());
                    } catch (Exception ex) {
                        Logger.getLogger(TransactionBean.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case "Name":
                    try {
                        transactions = transactionFacade.searchTransactionByName(input);
                        t = "";
                        int count = 0;
                        for (Transactions tr: transactions){
                            String tt = "";
                            for (TransactionType tp: tr.getTransactionType()){
                                tt += tp.getTypeName() + " ";
                            }
                            t += "{\"no\":" + tr.getTransactionNO() + ",\"name\":\"" + tr.getTransactionName() + 
                                    "\",\"type\":\"" + tt + "\",\"description\":\"" +  tr.getDescription() + "\"}";
                            count += 1;
                            if (transactions.size() != count){
                                t += ";";
                            }
                        }
                    } catch (Exception ex) {
                        Logger.getLogger(TransactionBean.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;

                case "Type":
                    try {
                        transactions = transactionFacade.searchTransactionByType(input);
                        t = "";
                        int count = 0;
                        for (Transactions tr: transactions){
                            String tt = "";
                            for (TransactionType tp: tr.getTransactionType()){
                                tt += tp.getTypeName() + " ";
                            }
                            t += "{\"no\":" + tr.getTransactionNO() + ",\"name\":\"" + tr.getTransactionName() + 
                                    "\",\"type\":\"" + tt + "\",\"description\":\"" +  tr.getDescription() + "\"}";
                            count += 1;
                            if (transactions.size() != count){
                                t += ";";
                            }
                        }
                    } catch (Exception ex) {
                        Logger.getLogger(TransactionBean.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
            }

    }
    
    public String getParameter(String key) {
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
        return params.get(key);
    }
    
    @PostConstruct
    public void checkIn(){
        String transactionNO = getParameter("transactionNO");
        if (transactionNO != null && !transactionNO.isEmpty()){
            try {
                System.out.println("aaaad d" + transactionNO);
                transactionFacade.updateTransactionState(Integer.parseInt(transactionNO));
            } catch (Exception ex) {
                Logger.getLogger(TransactionBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

}
