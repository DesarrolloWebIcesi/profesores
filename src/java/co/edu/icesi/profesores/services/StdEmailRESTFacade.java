/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.profesores.services;

import co.edu.icesi.profesores.controllers.StdEmailJpaController;
import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.naming.InitialContext;
import co.edu.icesi.profesores.entities.StdEmail;
import co.edu.icesi.profesores.entities.StdEmailPK;
import java.net.URI;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 *
 * @author 1130619373
 */
@Path("co.edu.icesi.profesores.entities.stdemail")
public class StdEmailRESTFacade {

    private EntityManagerFactory getEntityManagerFactory() throws NamingException {
        return (EntityManagerFactory) new InitialContext().lookup("java:comp/env/persistence-factory");
    }

    private StdEmailJpaController getJpaController() {
        try {
            return new StdEmailJpaController(getEntityManagerFactory());
        } catch (NamingException ex) {
            throw new RuntimeException(ex);
        }
    }

    public StdEmailRESTFacade() {
    }

    @POST
    @Consumes({"application/xml", "application/json"})
    public Response create(StdEmail entity) {
        try {
            getJpaController().create(entity);
            return Response.created(URI.create(entity.getStdEmailPK().getIdOrganization() + "," + entity.getStdEmailPK().getStdIdPerson() + "," + entity.getStdEmailPK().getStdOrMail())).build();
        } catch (Exception ex) {
            return Response.notModified(ex.getMessage()).build();
        }
    }

    @PUT
    @Consumes({"application/xml", "application/json"})
    public Response edit(StdEmail entity) {
        try {
            getJpaController().edit(entity);
            return Response.ok().build();
        } catch (Exception ex) {
            return Response.notModified(ex.getMessage()).build();
        }
    }

    @DELETE
    @Path("{id}")
    public Response remove(@PathParam("id") StdEmailPK id) {
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
    public StdEmail find(@PathParam("id") StdEmailPK id) {
        return getJpaController().findStdEmail(id);
    }

    @GET
    @Produces({"application/xml", "application/json"})
    public List<StdEmail> findAll() {
        return getJpaController().findStdEmailEntities();
    }

    @GET
    @Path("{max}/{first}")
    @Produces({"application/xml", "application/json"})
    public List<StdEmail> findRange(@PathParam("max") Integer max, @PathParam("first") Integer first) {
        return getJpaController().findStdEmailEntities(max, first);
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String count() {
        return String.valueOf(getJpaController().getStdEmailCount());
    }
    
}
