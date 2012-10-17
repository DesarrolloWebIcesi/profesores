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
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 *
 * @author 1130619373
 */
@Path("co.edu.icesi.profesores.entities.stdhracadbackgr")
public class StdHrAcadBackgrRESTFacade {

    private EntityManagerFactory getEntityManagerFactory() throws NamingException {
        return (EntityManagerFactory) new InitialContext().lookup("java:comp/env/persistence-factory");
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

    @POST
    @Consumes({"application/xml", "application/json"})
    public Response create(StdHrAcadBackgr entity) {
        try {
            getJpaController().create(entity);
            return Response.created(URI.create(entity.getStdHrAcadBackgrPK().getIdOrganization() + "," + entity.getStdHrAcadBackgrPK().getStdIdHr() + "," + entity.getStdHrAcadBackgrPK().getStdOrdAcdBack())).build();
        } catch (Exception ex) {
            return Response.notModified(ex.getMessage()).build();
        }
    }

    @PUT
    @Consumes({"application/xml", "application/json"})
    public Response edit(StdHrAcadBackgr entity) {
        try {
            getJpaController().edit(entity);
            return Response.ok().build();
        } catch (Exception ex) {
            return Response.notModified(ex.getMessage()).build();
        }
    }

    @DELETE
    @Path("{id}")
    public Response remove(@PathParam("id") StdHrAcadBackgrPK id) {
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
    public StdHrAcadBackgr find(@PathParam("id") StdHrAcadBackgrPK id) {
        return getJpaController().findStdHrAcadBackgr(id);
    }

    @GET
    @Produces({"application/xml", "application/json"})
    public List<StdHrAcadBackgr> findAll() {
        return getJpaController().findStdHrAcadBackgrEntities();
    }

    @GET
    @Path("{max}/{first}")
    @Produces({"application/xml", "application/json"})
    public List<StdHrAcadBackgr> findRange(@PathParam("max") Integer max, @PathParam("first") Integer first) {
        return getJpaController().findStdHrAcadBackgrEntities(max, first);
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String count() {
        return String.valueOf(getJpaController().getStdHrAcadBackgrCount());
    }
    
}
