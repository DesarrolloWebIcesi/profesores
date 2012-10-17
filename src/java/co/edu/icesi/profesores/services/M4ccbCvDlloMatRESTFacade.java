/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.profesores.services;

import co.edu.icesi.profesores.controllers.M4ccbCvDlloMatJpaController;
import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.naming.InitialContext;
import co.edu.icesi.profesores.entities.M4ccbCvDlloMat;
import co.edu.icesi.profesores.entities.M4ccbCvDlloMatPK;
import java.net.URI;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 *
 * @author 1130619373
 */
@Path("co.edu.icesi.profesores.entities.m4ccbcvdllomat")
public class M4ccbCvDlloMatRESTFacade {

    private EntityManagerFactory getEntityManagerFactory() throws NamingException {
        return (EntityManagerFactory) new InitialContext().lookup("java:comp/env/persistence-factory");
    }

    private M4ccbCvDlloMatJpaController getJpaController() {
        try {
            return new M4ccbCvDlloMatJpaController(getEntityManagerFactory());
        } catch (NamingException ex) {
            throw new RuntimeException(ex);
        }
    }

    public M4ccbCvDlloMatRESTFacade() {
    }

    @POST
    @Consumes({"application/xml", "application/json"})
    public Response create(M4ccbCvDlloMat entity) {
        try {
            getJpaController().create(entity);
            return Response.created(URI.create(entity.getM4ccbCvDlloMatPK().getIdOrganization() + "," + entity.getM4ccbCvDlloMatPK().getCcbOrDesMat() + "," + entity.getM4ccbCvDlloMatPK().getStdIdHr().toString())).build();
        } catch (Exception ex) {
            return Response.notModified(ex.getMessage()).build();
        }
    }

    @PUT
    @Consumes({"application/xml", "application/json"})
    public Response edit(M4ccbCvDlloMat entity) {
        try {
            getJpaController().edit(entity);
            return Response.ok().build();
        } catch (Exception ex) {
            return Response.notModified(ex.getMessage()).build();
        }
    }

    @DELETE
    @Path("{id}")
    public Response remove(@PathParam("id") M4ccbCvDlloMatPK id) {
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
    public M4ccbCvDlloMat find(@PathParam("id") M4ccbCvDlloMatPK id) {
        return getJpaController().findM4ccbCvDlloMat(id);
    }

    @GET
    @Produces({"application/xml", "application/json"})
    public List<M4ccbCvDlloMat> findAll() {
        return getJpaController().findM4ccbCvDlloMatEntities();
    }

    @GET
    @Path("{max}/{first}")
    @Produces({"application/xml", "application/json"})
    public List<M4ccbCvDlloMat> findRange(@PathParam("max") Integer max, @PathParam("first") Integer first) {
        return getJpaController().findM4ccbCvDlloMatEntities(max, first);
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String count() {
        return String.valueOf(getJpaController().getM4ccbCvDlloMatCount());
    }
    
}
