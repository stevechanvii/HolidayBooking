/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.assignment.type.services;

import fit5042.assignment.entity.TransactionType;
import fit5042.assignment.facade.TransactionTypeFacade;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;

/**
 * REST Web Service
 *
 * @author Messom
 */
@Path("greeting")
public class TypeManagementService {
    @EJB
    private TransactionTypeFacade tranTypeFacade;
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of helloworld
     */
    public TypeManagementService() {
    }

    /**
     * Retrieves representation of an instance of helloworld.helloworld
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("text/html")
    public String getHtml() {
        try {
            //TODO return proper representation object
            return "<html><body><h1>Hello "+tranTypeFacade.getAllTransactionType().toString()+"!</h1></body></html>";
            //throw new UnsupportedOperationException();
        } catch (Exception ex) {
            Logger.getLogger(TypeManagementService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    /**
     * POST method for updating an instance of HelloWorldResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @POST
    @Consumes("application/x-www-form-urlencoded") 
    public void setPostName( @FormParam("name") String content) {
        TransactionType tt = new TransactionType(content);
        try {
            tranTypeFacade.createTransactionType(tt);
        } catch (Exception ex) {
            Logger.getLogger(TypeManagementService.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.print(content + "aaaaaa");
//        return "<html><body><h1>Hello "+nameStorage.getName()+"!</h1></body></html>";
    }
    /**
     * PUT method for updating or creating an instance of helloworld
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("text/html")
    public void putHtml(String content) {
    }


}
