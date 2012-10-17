/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.profesores.services;

import co.edu.icesi.profesores.controllers.StdPersonJpaController;
import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.naming.InitialContext;
import co.edu.icesi.profesores.entities.StdPerson;
import co.edu.icesi.profesores.entities.StdPersonPK;
import java.net.URI;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 *
 * @author 1130619373
 */
@Path("co.edu.icesi.profesores.entities.stdperson")
public class StdPersonRESTFacade {

    private EntityManagerFactory getEntityManagerFactory() throws NamingException {
        return (EntityManagerFactory) new InitialContext().lookup("java:comp/env/persistence-factory");
    }

    private StdPersonJpaController getJpaController() {
        try {
            return new StdPersonJpaController(getEntityManagerFactory());
        } catch (NamingException ex) {
            throw new RuntimeException(ex);
        }
    }

    public StdPersonRESTFacade() {
    }

    @POST
    @Consumes({"application/xml", "application/json"})
    public Response create(StdPerson entity) {
        try {
            getJpaController().create(entity);
            return Response.created(URI.create(entity.getStdPersonPK().getIdOrganization() + "," + entity.getStdPersonPK().getStdIdPerson().toString())).build();
        } catch (Exception ex) {
            return Response.notModified(ex.getMessage()).build();
        }
    }

    @PUT
    @Consumes({"application/xml", "application/json"})
    public Response edit(StdPerson entity) {
        try {
            getJpaController().edit(entity);
            return Response.ok().build();
        } catch (Exception ex) {
            return Response.notModified(ex.getMessage()).build();
        }
    }

    @DELETE
    @Path("{id}")
    public Response remove(@PathParam("id") StdPersonPK id) {
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
    public StdPerson find(@PathParam("id") StdPersonPK id) {
        return getJpaController().findStdPerson(id);
    }

    @GET
    @Produces({"application/xml", "application/json"})
    public List<StdPerson> findAll() {
        return getJpaController().findStdPersonEntities();
    }

    @GET
    @Path("{max}/{first}")
    @Produces({"application/xml", "application/json"})
    public List<StdPerson> findRange(@PathParam("max") Integer max, @PathParam("first") Integer first) {
        return getJpaController().findStdPersonEntities(max, first);
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String count() {
        return String.valueOf(getJpaController().getStdPersonCount());
    }
    
}
