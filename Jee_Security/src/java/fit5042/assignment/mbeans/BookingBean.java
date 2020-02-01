/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.assignment.mbeans;

import fit5042.assignment.entity.Public;
import fit5042.assignment.entity.TransactionType;
import fit5042.assignment.entity.Transactions;
import fit5042.assignment.facade.TransactionFacade;
import fit5042.assignment.facade.TransactionTypeFacade;
import fit5042.assignment.facade.UserFacade;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author stevechanvii
 */
@ManagedBean(name = "bookingBean", eager = true)
@RequestScoped
public class BookingBean {
    @EJB
    private TransactionTypeFacade transactionTypeFacade;
    @EJB
    private TransactionFacade transactionFacade;
    @EJB
    private UserFacade userFacade;

    private String name;
    private String[] type = {"Cash"};
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getType() {
        return type;
    }

    public void setType(String[] type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void addTransaction(){
//        System.out.println("aaaa " + name + " " + type[0] + " " + description);
        List<TransactionType> transactionList = new ArrayList<>();
        for (String t : type){
            try {
                transactionList.add(transactionTypeFacade.searchTransactionTypeByNO(Integer.parseInt(t)).get(0));
                System.out.println(transactionList.get(0).getTypeName());
            } catch (Exception ex) {
                Logger.getLogger(BookingBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        try {
            FacesContext fc = FacesContext.getCurrentInstance();
            Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
            String userEmail =  params.get("userEmail"); 
            Public user = userFacade.getUserByEmail(userEmail).get(0);
            transactionFacade.createTransaction(new Transactions(name, description,transactionList, user));
        } catch (Exception ex) {
            Logger.getLogger(BookingBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
