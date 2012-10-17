/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.profesores.services;

import co.edu.icesi.profesores.controllers.StdHrPrevJobsJpaController;
import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.naming.InitialContext;
import co.edu.icesi.profesores.entities.StdHrPrevJobs;
import co.edu.icesi.profesores.entities.StdHrPrevJobsPK;
import java.net.URI;
import java.util.List;
import javax.persistence.Persistence;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 *
 * @author 1130619373
 */
@Path("prevjobs")
public class StdHrPrevJobsRESTFacade {

    private EntityManagerFactory getEntityManagerFactory() throws NamingException {
        return Persistence.createEntityManagerFactory("profesoresPU");
    }

    private StdHrPrevJobsJpaController getJpaController() {
        try {
            return new StdHrPrevJobsJpaController(getEntityManagerFactory());
        } catch (NamingException ex) {
            throw new RuntimeException(ex);
        }
    }

    public StdHrPrevJobsRESTFacade() {
    }

    @GET
    @Path("{id}/{professorid}")
    @Produces({"application/xml", "application/json"})
    public StdHrPrevJobs find(@PathParam("id") int id, @PathParam("professorid") String professorId) {
        StdHrPrevJobsPK pk = new StdHrPrevJobsPK("0000", professorId, ((Integer)(id)).shortValue());
        return getJpaController().findStdHrPrevJobs(pk);
    }

    @GET
    @Produces({"application/xml", "application/json"})
    public List<StdHrPrevJobs> findAll() {
        return getJpaController().findStdHrPrevJobsEntities();
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String count() {
        return String.valueOf(getJpaController().getStdHrPrevJobsCount());
    }
    
}
