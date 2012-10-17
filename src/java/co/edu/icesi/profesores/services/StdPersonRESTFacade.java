/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.profesores.services;

import co.edu.icesi.profesores.controllers.StdPersonJpaController;
import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.naming.InitialContext;
import co.edu.icesi.profesores.entities.StdPerson;
import co.edu.icesi.profesores.entities.StdPersonPK;
import java.net.URI;
import java.util.List;
import javax.persistence.Persistence;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 *
 * @author 1130619373
 */
@Path("stdperson")
public class StdPersonRESTFacade {

    private EntityManagerFactory getEntityManagerFactory() throws NamingException {
        return Persistence.createEntityManagerFactory("profesoresPU");
    }

    private StdPersonJpaController getJpaController() {
        try {
            return new StdPersonJpaController(getEntityManagerFactory());
        } catch (NamingException ex) {
            throw new RuntimeException(ex);
        }
    }

    public StdPersonRESTFacade() {
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public StdPerson find(@PathParam("id") String id) {
        StdPersonPK pk=new StdPersonPK("0000", id);
        return getJpaController().findStdPerson(pk);
    }

    @GET
    @Produces({"application/xml", "application/json"})
    public List<StdPerson> findAll() {
        return getJpaController().findStdPersonEntities();
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String count() {
        return String.valueOf(getJpaController().getStdPersonCount());
    }
    
}
