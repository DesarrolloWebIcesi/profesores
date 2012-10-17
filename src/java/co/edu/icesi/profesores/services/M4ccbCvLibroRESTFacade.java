/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.profesores.services;

import co.edu.icesi.profesores.controllers.M4ccbCvLibroJpaController;
import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.naming.InitialContext;
import co.edu.icesi.profesores.entities.M4ccbCvLibro;
import co.edu.icesi.profesores.entities.M4ccbCvLibroPK;
import java.net.URI;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 *
 * @author 1130619373
 */
@Path("co.edu.icesi.profesores.entities.m4ccbcvlibro")
public class M4ccbCvLibroRESTFacade {

    private EntityManagerFactory getEntityManagerFactory() throws NamingException {
        return (EntityManagerFactory) new InitialContext().lookup("java:comp/env/persistence-factory");
    }

    private M4ccbCvLibroJpaController getJpaController() {
        try {
            return new M4ccbCvLibroJpaController(getEntityManagerFactory());
        } catch (NamingException ex) {
            throw new RuntimeException(ex);
        }
    }

    public M4ccbCvLibroRESTFacade() {
    }

    @POST
    @Consumes({"application/xml", "application/json"})
    public Response create(M4ccbCvLibro entity) {
        try {
            getJpaController().create(entity);
            return Response.created(URI.create(entity.getM4ccbCvLibroPK().getIdOrganization() + "," + entity.getM4ccbCvLibroPK().getCcbOrLibro() + "," + entity.getM4ccbCvLibroPK().getStdIdHr().toString())).build();
        } catch (Exception ex) {
            return Response.notModified(ex.getMessage()).build();
        }
    }

    @PUT
    @Consumes({"application/xml", "application/json"})
    public Response edit(M4ccbCvLibro entity) {
        try {
            getJpaController().edit(entity);
            return Response.ok().build();
        } catch (Exception ex) {
            return Response.notModified(ex.getMessage()).build();
        }
    }

    @DELETE
    @Path("{id}")
    public Response remove(@PathParam("id") M4ccbCvLibroPK id) {
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
    public M4ccbCvLibro find(@PathParam("id") M4ccbCvLibroPK id) {
        return getJpaController().findM4ccbCvLibro(id);
    }

    @GET
    @Produces({"application/xml", "application/json"})
    public List<M4ccbCvLibro> findAll() {
        return getJpaController().findM4ccbCvLibroEntities();
    }

    @GET
    @Path("{max}/{first}")
    @Produces({"application/xml", "application/json"})
    public List<M4ccbCvLibro> findRange(@PathParam("max") Integer max, @PathParam("first") Integer first) {
        return getJpaController().findM4ccbCvLibroEntities(max, first);
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String count() {
        return String.valueOf(getJpaController().getM4ccbCvLibroCount());
    }
    
}
