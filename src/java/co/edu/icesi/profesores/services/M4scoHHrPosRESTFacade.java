/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.profesores.services;

import co.edu.icesi.profesores.controllers.M4scoHHrPosJpaController;
import co.edu.icesi.profesores.entities.M4scoHHrPos;
import co.edu.icesi.profesores.entities.M4scoHHrPosPK;
import java.util.List;
import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.*;

/**
 *
 * @author 1130619373
 */
@Path("m4scohhrpos")
public class M4scoHHrPosRESTFacade {

    private EntityManagerFactory getEntityManagerFactory() throws NamingException {
        return Persistence.createEntityManagerFactory("profesoresPU");
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

    @GET
    @Path("{id}/{personid}")
    @Produces({"application/xml", "application/json"})
    public M4scoHHrPos find(@PathParam("id") int id, @PathParam("personid") String personId) {
        M4scoHHrPosPK pk = new M4scoHHrPosPK("0000",personId, ((Integer)(id)).shortValue());
        return getJpaController().findM4scoHHrPos(pk);
    }

    @GET
    @Produces({"application/xml", "application/json"})
    public List<M4scoHHrPos> findAll() {
        return getJpaController().findM4scoHHrPosEntities();
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String count() {
        return String.valueOf(getJpaController().getM4scoHHrPosCount());
    }
    
}
