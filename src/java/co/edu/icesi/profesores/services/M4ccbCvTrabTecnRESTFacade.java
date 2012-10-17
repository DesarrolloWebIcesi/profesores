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
import javax.persistence.Persistence;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 *
 * @author 1130619373
 */
@Path("trabtecn")
public class M4ccbCvTrabTecnRESTFacade {

    private EntityManagerFactory getEntityManagerFactory() throws NamingException {
        return Persistence.createEntityManagerFactory("profesoresPU");
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

    @GET
    @Path("{id}/{professorid}")
    @Produces({"application/xml", "application/json"})
    public M4ccbCvTrabTecn find(@PathParam("id") int id, @PathParam("professorid") String professorId) {
        M4ccbCvTrabTecnPK pk = new M4ccbCvTrabTecnPK("0000", ((Integer)(id)).shortValue(), professorId);
        return getJpaController().findM4ccbCvTrabTecn(pk);
    }

    @GET
    @Produces({"application/xml", "application/json"})
    public List<M4ccbCvTrabTecn> findAll() {
        return getJpaController().findM4ccbCvTrabTecnEntities();
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String count() {
        return String.valueOf(getJpaController().getM4ccbCvTrabTecnCount());
    }
    
}
