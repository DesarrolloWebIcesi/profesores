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
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 *
 * @author 1130619373
 */
@Path("co.edu.icesi.profesores.entities.stdhrprevjobs")
public class StdHrPrevJobsRESTFacade {

    private EntityManagerFactory getEntityManagerFactory() throws NamingException {
        return (EntityManagerFactory) new InitialContext().lookup("java:comp/env/persistence-factory");
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

    @POST
    @Consumes({"application/xml", "application/json"})
    public Response create(StdHrPrevJobs entity) {
        try {
            getJpaController().create(entity);
            return Response.created(URI.create(entity.getStdHrPrevJobsPK().getIdOrganization() + "," + entity.getStdHrPrevJobsPK().getStdIdHr() + "," + entity.getStdHrPrevJobsPK().getStdOrProfBackg())).build();
        } catch (Exception ex) {
            return Response.notModified(ex.getMessage()).build();
        }
    }

    @PUT
    @Consumes({"application/xml", "application/json"})
    public Response edit(StdHrPrevJobs entity) {
        try {
            getJpaController().edit(entity);
            return Response.ok().build();
        } catch (Exception ex) {
            return Response.notModified(ex.getMessage()).build();
        }
    }

    @DELETE
    @Path("{id}")
    public Response remove(@PathParam("id") StdHrPrevJobsPK id) {
        try {
            getJpaController().destroy(id);
            return Response.ok().build();
        } catch (Exception ex) {
            return Response.notModified(ex.getMessage()).build();
        }
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public StdHrPrevJobs find(@PathParam("id") StdHrPrevJobsPK id) {
        return getJpaController().findStdHrPrevJobs(id);
    }

    @GET
    @Produces({"application/xml", "application/json"})
    public List<StdHrPrevJobs> findAll() {
        return getJpaController().findStdHrPrevJobsEntities();
    }

    @GET
    @Path("{max}/{first}")
    @Produces({"application/xml", "application/json"})
    public List<StdHrPrevJobs> findRange(@PathParam("max") Integer max, @PathParam("first") Integer first) {
        return getJpaController().findStdHrPrevJobsEntities(max, first);
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String count() {
        return String.valueOf(getJpaController().getStdHrPrevJobsCount());
    }
    
}
