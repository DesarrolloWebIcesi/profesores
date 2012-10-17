/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.profesores.services;

import co.edu.icesi.profesores.controllers.StdHrAcadBackgrJpaController;
import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.naming.InitialContext;
import co.edu.icesi.profesores.entities.StdHrAcadBackgr;
import co.edu.icesi.profesores.entities.StdHrAcadBackgrPK;
import java.net.URI;
import java.util.List;
import javax.persistence.Persistence;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 *
 * @author 1130619373
 */
@Path("acadbackgr")
public class StdHrAcadBackgrRESTFacade {

    private EntityManagerFactory getEntityManagerFactory() throws NamingException {
        return Persistence.createEntityManagerFactory("profesoresPU");
    }

    private StdHrAcadBackgrJpaController getJpaController() {
        try {
            return new StdHrAcadBackgrJpaController(getEntityManagerFactory());
        } catch (NamingException ex) {
            throw new RuntimeException(ex);
        }
    }

    public StdHrAcadBackgrRESTFacade() {
    }

    @GET
    @Path("{id}/{professoris}")
    @Produces({"application/xml", "application/json"})
    public StdHrAcadBackgr find(@PathParam("id") int id, @PathParam("professorid") String professorId) {
        StdHrAcadBackgrPK pk = new StdHrAcadBackgrPK("0000", professorId, ((Integer)(id)).shortValue());
        return getJpaController().findStdHrAcadBackgr(pk);
    }

    @GET
    @Produces({"application/xml", "application/json"})
    public List<StdHrAcadBackgr> findAll() {
        return getJpaController().findStdHrAcadBackgrEntities();
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String count() {
        return String.valueOf(getJpaController().getStdHrAcadBackgrCount());
    }
    
}
