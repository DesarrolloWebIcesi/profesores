/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.profesores.services;

import co.edu.icesi.profesores.controllers.M4ccbCvPrefEpilJpaController;
import co.edu.icesi.profesores.entities.M4ccbCvPrefEpil;
import co.edu.icesi.profesores.entities.M4ccbCvPrefEpilPK;
import java.util.List;
import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.*;

/**
 *
 * @author 1130619373
 */
@Path("prefepil")
public class M4ccbCvPrefEpilRESTFacade {

    private EntityManagerFactory getEntityManagerFactory() throws NamingException {
        return Persistence.createEntityManagerFactory("profesoresPU");
    }

    private M4ccbCvPrefEpilJpaController getJpaController() {
        try {
            return new M4ccbCvPrefEpilJpaController(getEntityManagerFactory());
        } catch (NamingException ex) {
            throw new RuntimeException(ex);
        }
    }

    public M4ccbCvPrefEpilRESTFacade() {
    }

    @GET
    @Path("{id}/{professorid}")
    @Produces({"application/xml", "application/json"})
    public M4ccbCvPrefEpil find(@PathParam("id") int id, @PathParam("professorid") String professorId) {
        M4ccbCvPrefEpilPK pk = new M4ccbCvPrefEpilPK("0000", ((Integer)(id)).shortValue(), professorId);
        return getJpaController().findM4ccbCvPrefEpil(pk);
    }

    @GET
    @Produces({"application/xml", "application/json"})
    public List<M4ccbCvPrefEpil> findAll() {
        return getJpaController().findM4ccbCvPrefEpilEntities();
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String count() {
        return String.valueOf(getJpaController().getM4ccbCvPrefEpilCount());
    }
    
}
