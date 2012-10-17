/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.profesores.services;

import co.edu.icesi.profesores.controllers.M4ccbCvCapLibJpaController;
import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.naming.InitialContext;
import co.edu.icesi.profesores.entities.M4ccbCvCapLib;
import co.edu.icesi.profesores.entities.M4ccbCvCapLibPK;
import java.net.URI;
import java.util.List;
import javax.persistence.Persistence;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 *
 * @author 1130619373
 */
@Path("caplib")
public class M4ccbCvCapLibRESTFacade {

    private EntityManagerFactory getEntityManagerFactory() throws NamingException {
        return Persistence.createEntityManagerFactory("profesoresPU");
    }

    private M4ccbCvCapLibJpaController getJpaController() {
        try {
            return new M4ccbCvCapLibJpaController(getEntityManagerFactory());
        } catch (NamingException ex) {
            throw new RuntimeException(ex);
        }
    }

    public M4ccbCvCapLibRESTFacade() {
    }

    @GET
    @Path("{id}/{professorid}")
    @Produces({"application/xml", "application/json"})
    public M4ccbCvCapLib find(@PathParam("id") int id, @PathParam("professorid") String professorId) {
        M4ccbCvCapLibPK pk=new M4ccbCvCapLibPK("0000", ((Integer)(id)).shortValue(), professorId);
        return getJpaController().findM4ccbCvCapLib(pk);
    }

    @GET
    @Produces({"application/xml", "application/json"})
    public List<M4ccbCvCapLib> findAll() {
        return getJpaController().findM4ccbCvCapLibEntities();
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String count() {
        return String.valueOf(getJpaController().getM4ccbCvCapLibCount());
    }
    
}
