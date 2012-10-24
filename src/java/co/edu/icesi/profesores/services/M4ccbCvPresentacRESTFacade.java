/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.profesores.services;

import co.edu.icesi.profesores.controllers.M4ccbCvPresentacJpaController;
import co.edu.icesi.profesores.entities.M4ccbCvPresentac;
import co.edu.icesi.profesores.entities.M4ccbCvPresentacPK;
import java.net.URI;
import java.util.List;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 *
 * @author 14620701
 */
@Path("co.edu.icesi.profesores.entities.m4ccbcvpresentac")
public class M4ccbCvPresentacRESTFacade {

    private EntityManagerFactory getEntityManagerFactory() throws NamingException {
         return Persistence.createEntityManagerFactory("profesoresPU");
    }

    private M4ccbCvPresentacJpaController getJpaController() {
        try {
            return new M4ccbCvPresentacJpaController(getEntityManagerFactory());
        } catch (NamingException ex) {
            throw new RuntimeException(ex);
        }
    }

    public M4ccbCvPresentacRESTFacade() {
    }    

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public M4ccbCvPresentac find(@PathParam("id") M4ccbCvPresentacPK id) {
        return getJpaController().findM4ccbCvPresentac(id);
    }

    @GET
    @Produces({"application/xml", "application/json"})
    public List<M4ccbCvPresentac> findAll() {
        return getJpaController().findM4ccbCvPresentacEntities();
    }

    @GET
    @Path("{max}/{first}")
    @Produces({"application/xml", "application/json"})
    public List<M4ccbCvPresentac> findRange(@PathParam("max") Integer max, @PathParam("first") Integer first) {
        return getJpaController().findM4ccbCvPresentacEntities(max, first);
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String count() {
        return String.valueOf(getJpaController().getM4ccbCvPresentacCount());
    }
    
}
