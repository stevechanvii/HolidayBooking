/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.assignment.mbeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.security.Principal;

/**
 *
 * @author stevechanvii
 */
@ManagedBean(name = "sessionController")
@SessionScoped
public class SessionController {

//    @EJB
//    private UserFacade userFacade;

    private String email;

    public SessionController() {
        Principal principal = FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();
        // get login from principal
        email = principal.getName();
        //get all informations of user from EJB : UserFacade
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
