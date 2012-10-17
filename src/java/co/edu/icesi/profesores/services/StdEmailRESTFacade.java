/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.profesores.services;

import co.edu.icesi.profesores.controllers.StdEmailJpaController;
import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.naming.InitialContext;
import co.edu.icesi.profesores.entities.StdEmail;
import co.edu.icesi.profesores.entities.StdEmailPK;
import java.net.URI;
import java.util.List;
import javax.persistence.Persistence;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 *
 * @author 1130619373
 */
@Path("stdemail")
public class StdEmailRESTFacade {

    private EntityManagerFactory getEntityManagerFactory() throws NamingException {
        return Persistence.createEntityManagerFactory("profesoresPU");
    }

    private StdEmailJpaController getJpaController() {
        try {
            return new StdEmailJpaController(getEntityManagerFactory());
        } catch (NamingException ex) {
            throw new RuntimeException(ex);
        }
    }

    public StdEmailRESTFacade() {
    }

    @GET
    @Path("{id}/{personid}")
    @Produces({"application/xml", "application/json"})
    public StdEmail find(@PathParam("id") int id, @PathParam("personid") String personId) {
        StdEmailPK pk = new StdEmailPK("0000", personId, ((Integer)(id)).shortValue());
        return getJpaController().findStdEmail(pk);
    }

    @GET
    @Produces({"application/xml", "application/json"})
    public List<StdEmail> findAll() {
        return getJpaController().findStdEmailEntities();
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String count() {
        return String.valueOf(getJpaController().getStdEmailCount());
    }
    
}
