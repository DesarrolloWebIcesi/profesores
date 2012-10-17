/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.profesores.services;

import co.edu.icesi.profesores.controllers.M4ccbCvTrabTecnJpaController;
import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.naming.InitialContext;
import co.edu.icesi.profesores.entities.M4ccbCvTrabTecn;
import co.edu.icesi.profesores.entities.M4ccbCvTrabTecnPK;
import java.net.URI;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 *
 * @author 1130619373
 */
@Path("co.edu.icesi.profesores.entities.m4ccbcvtrabtecn")
public class M4ccbCvTrabTecnRESTFacade {

    private EntityManagerFactory getEntityManagerFactory() throws NamingException {
        return (EntityManagerFactory) new InitialContext().lookup("java:comp/env/persistence-factory");
    }

    private M4ccbCvTrabTecnJpaController getJpaController() {
        try {
            return new M4ccbCvTrabTecnJpaController(getEntityManagerFactory());
        } catch (NamingException ex) {
            throw new RuntimeException(ex);
        }
    }

    public M4ccbCvTrabTecnRESTFacade() {
    }

    @POST
    @Consumes({"application/xml", "application/json"})
    public Response create(M4ccbCvTrabTecn entity) {
        try {
            getJpaController().create(entity);
            return Response.created(URI.create(entity.getM4ccbCvTrabTecnPK().getIdOrganization() + "," + entity.getM4ccbCvTrabTecnPK().getCcbOrTrabTec() + "," + entity.getM4ccbCvTrabTecnPK().getStdIdHr().toString())).build();
        } catch (Exception ex) {
            return Response.notModified(ex.getMessage()).build();
        }
    }

    @PUT
    @Consumes({"application/xml", "application/json"})
    public Response edit(M4ccbCvTrabTecn entity) {
        try {
            getJpaController().edit(entity);
            return Response.ok().build();
        } catch (Exception ex) {
            return Response.notModified(ex.getMessage()).build();
        }
    }

    @DELETE
    @Path("{id}")
    public Response remove(@PathParam("id") M4ccbCvTrabTecnPK id) {
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
    public M4ccbCvTrabTecn find(@PathParam("id") M4ccbCvTrabTecnPK id) {
        return getJpaController().findM4ccbCvTrabTecn(id);
    }

    @GET
    @Produces({"application/xml", "application/json"})
    public List<M4ccbCvTrabTecn> findAll() {
        return getJpaController().findM4ccbCvTrabTecnEntities();
    }

    @GET
    @Path("{max}/{first}")
    @Produces({"application/xml", "application/json"})
    public List<M4ccbCvTrabTecn> findRange(@PathParam("max") Integer max, @PathParam("first") Integer first) {
        return getJpaController().findM4ccbCvTrabTecnEntities(max, first);
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String count() {
        return String.valueOf(getJpaController().getM4ccbCvTrabTecnCount());
    }
    
}
