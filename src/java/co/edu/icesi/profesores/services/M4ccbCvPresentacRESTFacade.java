/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.profesores.services;

import co.edu.icesi.profesores.controllers.M4ccbCvPresentacJpaController;
import co.edu.icesi.profesores.entities.M4ccbCvPresentac;
import co.edu.icesi.profesores.entities.M4ccbCvPresentacPK;
import java.util.List;
import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author 14620701
 */
@Path("present")
public class M4ccbCvPresentacRESTFacade {

    private EntityManagerFactory getEntityManagerFactory() throws NamingException {
         return Persistence.createEntityManagerFactory("profesoresPU");
    }

    private M4ccbCvPresentacJpaController getJpaController() {
        try {
            return new M4ccbCvPresentacJpaController(getEntityManagerFactory());
        } catch (NamingException ex) {
            throw new RuntimeException(ex);
        }
    }

    public M4ccbCvPresentacRESTFacade() {
    }    

    @GET
    @Path("{id}/{professorid}")
    @Produces({"application/xml", "application/json"})
    public M4ccbCvPresentac find(@PathParam("id") int id, @PathParam("professorid") String professorId) {
        M4ccbCvPresentacPK pk=new M4ccbCvPresentacPK("0000", ((Integer)(id)).shortValue(), professorId);
        return getJpaController().findM4ccbCvPresentac(pk);
    }

    @GET
    @Produces({"application/xml", "application/json"})
    public List<M4ccbCvPresentac> findAll() {
        return getJpaController().findM4ccbCvPresentacEntities();
    }
 
    @GET
    @Path("count")
    @Produces("text/plain")
    public String count() {
        return String.valueOf(getJpaController().getM4ccbCvPresentacCount());
    }
    
}
