/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.profesores.services;

import co.edu.icesi.profesores.controllers.M4ccbCvDocTrabJpaController;
import co.edu.icesi.profesores.entities.M4ccbCvDocTrab;
import co.edu.icesi.profesores.entities.M4ccbCvDocTrabPK;
import java.util.List;
import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.*;

/**
 *
 * @author 1130619373
 */
@Path("doctrab")
public class M4ccbCvDocTrabRESTFacade {

    private EntityManagerFactory getEntityManagerFactory() throws NamingException {
        return Persistence.createEntityManagerFactory("profesoresPU");
    }

    private M4ccbCvDocTrabJpaController getJpaController() {
        try {
            return new M4ccbCvDocTrabJpaController(getEntityManagerFactory());
        } catch (NamingException ex) {
            throw new RuntimeException(ex);
        }
    }

    public M4ccbCvDocTrabRESTFacade() {
    }

    @GET
    @Path("{id}/{professorid}")
    @Produces({"application/xml", "application/json"})
    public M4ccbCvDocTrab find(@PathParam("id") int id, @PathParam("professorid") String professorId) {
        M4ccbCvDocTrabPK pk = new M4ccbCvDocTrabPK("0000", ((Integer)(id)).shortValue(), professorId);
        return getJpaController().findM4ccbCvDocTrab(pk);
    }

    @GET
    @Produces({"application/xml", "application/json"})
    public List<M4ccbCvDocTrab> findAll() {
        return getJpaController().findM4ccbCvDocTrabEntities();
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String count() {
        return String.valueOf(getJpaController().getM4ccbCvDocTrabCount());
    }
    
}
