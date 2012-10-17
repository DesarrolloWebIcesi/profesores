/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.profesores.services;

import co.edu.icesi.profesores.controllers.M4ccbCvEdicionRJpaController;
import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.naming.InitialContext;
import co.edu.icesi.profesores.entities.M4ccbCvEdicionR;
import co.edu.icesi.profesores.entities.M4ccbCvEdicionRPK;
import java.net.URI;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 *
 * @author 1130619373
 */
@Path("co.edu.icesi.profesores.entities.m4ccbcvedicionr")
public class M4ccbCvEdicionRRESTFacade {

    private EntityManagerFactory getEntityManagerFactory() throws NamingException {
        return (EntityManagerFactory) new InitialContext().lookup("java:comp/env/persistence-factory");
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

    @POST
    @Consumes({"application/xml", "application/json"})
    public Response create(M4ccbCvEdicionR entity) {
        try {
            getJpaController().create(entity);
            return Response.created(URI.create(entity.getM4ccbCvEdicionRPK().getIdOrganization() + "," + entity.getM4ccbCvEdicionRPK().getCcbOrEdicRev() + "," + entity.getM4ccbCvEdicionRPK().getStdIdHr().toString())).build();
        } catch (Exception ex) {
            return Response.notModified(ex.getMessage()).build();
        }
    }

    @PUT
    @Consumes({"application/xml", "application/json"})
    public Response edit(M4ccbCvEdicionR entity) {
        try {
            getJpaController().edit(entity);
            return Response.ok().build();
        } catch (Exception ex) {
            return Response.notModified(ex.getMessage()).build();
        }
    }

    @DELETE
    @Path("{id}")
    public Response remove(@PathParam("id") M4ccbCvEdicionRPK id) {
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
    public M4ccbCvEdicionR find(@PathParam("id") M4ccbCvEdicionRPK id) {
        return getJpaController().findM4ccbCvEdicionR(id);
    }

    @GET
    @Produces({"application/xml", "application/json"})
    public List<M4ccbCvEdicionR> findAll() {
        return getJpaController().findM4ccbCvEdicionREntities();
    }

    @GET
    @Path("{max}/{first}")
    @Produces({"application/xml", "application/json"})
    public List<M4ccbCvEdicionR> findRange(@PathParam("max") Integer max, @PathParam("first") Integer first) {
        return getJpaController().findM4ccbCvEdicionREntities(max, first);
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String count() {
        return String.valueOf(getJpaController().getM4ccbCvEdicionRCount());
    }
    
}
