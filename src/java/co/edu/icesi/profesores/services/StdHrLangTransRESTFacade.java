/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.profesores.services;

import co.edu.icesi.profesores.controllers.StdHrLangTransJpaController;
import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.naming.InitialContext;
import co.edu.icesi.profesores.entities.StdHrLangTrans;
import co.edu.icesi.profesores.entities.StdHrLangTransPK;
import java.net.URI;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 *
 * @author 1130619373
 */
@Path("co.edu.icesi.profesores.entities.stdhrlangtrans")
public class StdHrLangTransRESTFacade {

    private EntityManagerFactory getEntityManagerFactory() throws NamingException {
        return (EntityManagerFactory) new InitialContext().lookup("java:comp/env/persistence-factory");
    }

    private StdHrLangTransJpaController getJpaController() {
        try {
            return new StdHrLangTransJpaController(getEntityManagerFactory());
        } catch (NamingException ex) {
            throw new RuntimeException(ex);
        }
    }

    public StdHrLangTransRESTFacade() {
    }

    @POST
    @Consumes({"application/xml", "application/json"})
    public Response create(StdHrLangTrans entity) {
        try {
            getJpaController().create(entity);
            return Response.created(URI.create(entity.getStdHrLangTransPK().getIdOrganization() + "," + entity.getStdHrLangTransPK().getStdIdHr() + "," + entity.getStdHrLangTransPK().getStdIdLanguage() + "," + entity.getStdHrLangTransPK().getStdIdLanguageTo() + "," + entity.getStdHrLangTransPK().getStdDtStart() + "," + entity.getStdHrLangTransPK().getCcbOrTraducc())).build();
        } catch (Exception ex) {
            return Response.notModified(ex.getMessage()).build();
        }
    }

    @PUT
    @Consumes({"application/xml", "application/json"})
    public Response edit(StdHrLangTrans entity) {
        try {
            getJpaController().edit(entity);
            return Response.ok().build();
        } catch (Exception ex) {
            return Response.notModified(ex.getMessage()).build();
        }
    }

    @DELETE
    @Path("{id}")
    public Response remove(@PathParam("id") StdHrLangTransPK id) {
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
    public StdHrLangTrans find(@PathParam("id") StdHrLangTransPK id) {
        return getJpaController().findStdHrLangTrans(id);
    }

    @GET
    @Produces({"application/xml", "application/json"})
    public List<StdHrLangTrans> findAll() {
        return getJpaController().findStdHrLangTransEntities();
    }

    @GET
    @Path("{max}/{first}")
    @Produces({"application/xml", "application/json"})
    public List<StdHrLangTrans> findRange(@PathParam("max") Integer max, @PathParam("first") Integer first) {
        return getJpaController().findStdHrLangTransEntities(max, first);
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String count() {
        return String.valueOf(getJpaController().getStdHrLangTransCount());
    }
    
}
