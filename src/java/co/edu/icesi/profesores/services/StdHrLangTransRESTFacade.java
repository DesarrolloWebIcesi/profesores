/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.profesores.services;

import co.edu.icesi.profesores.controllers.StdHrLangTransJpaController;
import co.edu.icesi.profesores.entities.StdHrLangTrans;
import co.edu.icesi.profesores.entities.StdHrLangTransPK;
import java.util.List;
import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.*;

/**
 *
 * @author 1130619373
 */
@Path("langtrans")
public class StdHrLangTransRESTFacade {

    private EntityManagerFactory getEntityManagerFactory() throws NamingException {
        return Persistence.createEntityManagerFactory("profesoresPU");
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

    @GET
    @Path("{id}/{professorid}")
    @Produces({"application/xml", "application/json"})
    public StdHrLangTrans find(@PathParam("id") int id, @PathParam("professorid") String professorId) {
        StdHrLangTransPK pk = new StdHrLangTransPK();
        pk.setIdOrganization("0000");
        pk.setCcbOrTraducc(((Integer)(id)).shortValue());
        pk.setStdIdHr(professorId);
        return getJpaController().findStdHrLangTrans(pk);
    }

    @GET
    @Produces({"application/xml", "application/json"})
    public List<StdHrLangTrans> findAll() {
        return getJpaController().findStdHrLangTransEntities();
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String count() {
        return String.valueOf(getJpaController().getStdHrLangTransCount());
    }
    
}
