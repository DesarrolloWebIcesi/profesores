/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.profesores.services;

import co.edu.icesi.profesores.controllers.M4scoPositionJpaController;
import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.naming.InitialContext;
import co.edu.icesi.profesores.entities.M4scoPosition;
import co.edu.icesi.profesores.entities.M4scoPositionPK;
import java.net.URI;
import java.util.List;
import javax.persistence.Persistence;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 *
 * @author 1130619373
 */
@Path("m4scoposition")
public class M4scoPositionRESTFacade {

    private EntityManagerFactory getEntityManagerFactory() throws NamingException {
        return Persistence.createEntityManagerFactory("profesoresPU");
    }

    private M4scoPositionJpaController getJpaController() {
        try {
            return new M4scoPositionJpaController(getEntityManagerFactory());
        } catch (NamingException ex) {
            throw new RuntimeException(ex);
        }
    }

    public M4scoPositionRESTFacade() {
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public M4scoPosition find(@PathParam("id") String id) {
        M4scoPositionPK pk=new M4scoPositionPK("0000", id);
        return getJpaController().findM4scoPosition(pk);
    }

    @GET
    @Produces({"application/xml", "application/json"})
    public List<M4scoPosition> findAll() {
        return getJpaController().findM4scoPositionEntities();
    }

    @GET
    @Path("{max}/{first}")
    @Produces({"application/xml", "application/json"})
    public List<M4scoPosition> findRange(@PathParam("max") Integer max, @PathParam("first") Integer first) {
        return getJpaController().findM4scoPositionEntities(max, first);
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String count() {
        return String.valueOf(getJpaController().getM4scoPositionCount());
    }
    
}
