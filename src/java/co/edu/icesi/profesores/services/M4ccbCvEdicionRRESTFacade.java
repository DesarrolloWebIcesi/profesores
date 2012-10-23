/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.profesores.services;

import co.edu.icesi.profesores.controllers.M4ccbCvEdicionRJpaController;
import co.edu.icesi.profesores.entities.M4ccbCvEdicionR;
import co.edu.icesi.profesores.entities.M4ccbCvEdicionRPK;
import java.util.List;
import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.*;

/**
 *
 * @author 1130619373
 */
@Path("edicionr")
public class M4ccbCvEdicionRRESTFacade {

    private EntityManagerFactory getEntityManagerFactory() throws NamingException {
        return Persistence.createEntityManagerFactory("profesoresPU");
    }

    private M4ccbCvEdicionRJpaController getJpaController() {
        try {
            return new M4ccbCvEdicionRJpaController(getEntityManagerFactory());
        } catch (NamingException ex) {
            throw new RuntimeException(ex);
        }
    }

    public M4ccbCvEdicionRRESTFacade() {
    }

    @GET
    @Path("{id}/{professorid}")
    @Produces({"application/xml", "application/json"})
    public M4ccbCvEdicionR find(@PathParam("id") int id, @PathParam("professorid") String professorId) {
        M4ccbCvEdicionRPK pk = new M4ccbCvEdicionRPK("0000", ((Integer)(id)).shortValue(), professorId);
        return getJpaController().findM4ccbCvEdicionR(pk);
    }

    @GET
    @Produces({"application/xml", "application/json"})
    public List<M4ccbCvEdicionR> findAll() {
        return getJpaController().findM4ccbCvEdicionREntities();
    }
    
    @GET
    @Path("count")
    @Produces("text/plain")
    public String count() {
        return String.valueOf(getJpaController().getM4ccbCvEdicionRCount());
    }
    
}
