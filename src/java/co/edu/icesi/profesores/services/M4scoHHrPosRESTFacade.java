/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.profesores.services;

import co.edu.icesi.profesores.controllers.M4scoHHrPosJpaController;
import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.naming.InitialContext;
import co.edu.icesi.profesores.entities.M4scoHHrPos;
import co.edu.icesi.profesores.entities.M4scoHHrPosPK;
import java.net.URI;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 *
 * @author 1130619373
 */
@Path("co.edu.icesi.profesores.entities.m4scohhrpos")
public class M4scoHHrPosRESTFacade {

    private EntityManagerFactory getEntityManagerFactory() throws NamingException {
        return (EntityManagerFactory) new InitialContext().lookup("java:comp/env/persistence-factory");
    }

    private M4scoHHrPosJpaController getJpaController() {
        try {
            return new M4scoHHrPosJpaController(getEntityManagerFactory());
        } catch (NamingException ex) {
            throw new RuntimeException(ex);
        }
    }

    public M4scoHHrPosRESTFacade() {
    }

    @POST
    @Consumes({"application/xml", "application/json"})
    public Response create(M4scoHHrPos entity) {
        try {
            getJpaController().create(entity);
            return Response.created(URI.create(entity.getM4scoHHrPosPK().getIdOrganization() + "," + entity.getM4scoHHrPosPK().getScoIdHr() + "," + entity.getM4scoHHrPosPK().getScoOrHrRole())).build();
        } catch (Exception ex) {
            return Response.notModified(ex.getMessage()).build();
        }
    }

    @PUT
    @Consumes({"application/xml", "application/json"})
    public Response edit(M4scoHHrPos entity) {
        try {
            getJpaController().edit(entity);
            return Response.ok().build();
        } catch (Exception ex) {
            return Response.notModified(ex.getMessage()).build();
        }
    }

    @DELETE
    @Path("{id}")
    public Response remove(@PathParam("id") M4scoHHrPosPK id) {
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
    public M4scoHHrPos find(@PathParam("id") M4scoHHrPosPK id) {
        return getJpaController().findM4scoHHrPos(id);
    }

    @GET
    @Produces({"application/xml", "application/json"})
    public List<M4scoHHrPos> findAll() {
        return getJpaController().findM4scoHHrPosEntities();
    }

    @GET
    @Path("{max}/{first}")
    @Produces({"application/xml", "application/json"})
    public List<M4scoHHrPos> findRange(@PathParam("max") Integer max, @PathParam("first") Integer first) {
        return getJpaController().findM4scoHHrPosEntities(max, first);
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String count() {
        return String.valueOf(getJpaController().getM4scoHHrPosCount());
    }
    
}
