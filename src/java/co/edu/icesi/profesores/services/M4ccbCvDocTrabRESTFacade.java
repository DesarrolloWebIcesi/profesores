/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.profesores.services;

import co.edu.icesi.profesores.controllers.M4ccbCvDocTrabJpaController;
import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.naming.InitialContext;
import co.edu.icesi.profesores.entities.M4ccbCvDocTrab;
import co.edu.icesi.profesores.entities.M4ccbCvDocTrabPK;
import java.net.URI;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 *
 * @author 1130619373
 */
@Path("co.edu.icesi.profesores.entities.m4ccbcvdoctrab")
public class M4ccbCvDocTrabRESTFacade {

    private EntityManagerFactory getEntityManagerFactory() throws NamingException {
        return (EntityManagerFactory) new InitialContext().lookup("java:comp/env/persistence-factory");
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

    @POST
    @Consumes({"application/xml", "application/json"})
    public Response create(M4ccbCvDocTrab entity) {
        try {
            getJpaController().create(entity);
            return Response.created(URI.create(entity.getM4ccbCvDocTrabPK().getIdOrganization() + "," + entity.getM4ccbCvDocTrabPK().getCcbOrDocTrab() + "," + entity.getM4ccbCvDocTrabPK().getStdIdHr().toString())).build();
        } catch (Exception ex) {
            return Response.notModified(ex.getMessage()).build();
        }
    }

    @PUT
    @Consumes({"application/xml", "application/json"})
    public Response edit(M4ccbCvDocTrab entity) {
        try {
            getJpaController().edit(entity);
            return Response.ok().build();
        } catch (Exception ex) {
            return Response.notModified(ex.getMessage()).build();
        }
    }

    @DELETE
    @Path("{id}")
    public Response remove(@PathParam("id") M4ccbCvDocTrabPK id) {
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
    public M4ccbCvDocTrab find(@PathParam("id") M4ccbCvDocTrabPK id) {
        return getJpaController().findM4ccbCvDocTrab(id);
    }

    @GET
    @Produces({"application/xml", "application/json"})
    public List<M4ccbCvDocTrab> findAll() {
        return getJpaController().findM4ccbCvDocTrabEntities();
    }

    @GET
    @Path("{max}/{first}")
    @Produces({"application/xml", "application/json"})
    public List<M4ccbCvDocTrab> findRange(@PathParam("max") Integer max, @PathParam("first") Integer first) {
        return getJpaController().findM4ccbCvDocTrabEntities(max, first);
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String count() {
        return String.valueOf(getJpaController().getM4ccbCvDocTrabCount());
    }
    
}
