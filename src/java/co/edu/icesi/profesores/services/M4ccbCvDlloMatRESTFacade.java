/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.profesores.services;

import co.edu.icesi.profesores.controllers.M4ccbCvDlloMatJpaController;
import co.edu.icesi.profesores.entities.M4ccbCvDlloMat;
import co.edu.icesi.profesores.entities.M4ccbCvDlloMatPK;
import java.util.List;
import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.*;

/**
 *
 * @author 1130619373
 */
@Path("dllomat")
public class M4ccbCvDlloMatRESTFacade {

    private EntityManagerFactory getEntityManagerFactory() throws NamingException {
        return Persistence.createEntityManagerFactory("profesoresPU");
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

    @GET
    @Path("{id}/professorid")
    @Produces({"application/xml", "application/json"})
    public M4ccbCvDlloMat find(@PathParam("id") int id, @PathParam("professorid") String professorId) {
        M4ccbCvDlloMatPK pk= new M4ccbCvDlloMatPK("0000", ((Integer)(id)).shortValue(), professorId);
        return getJpaController().findM4ccbCvDlloMat(pk);
    }

    @GET
    @Produces({"application/xml", "application/json"})
    public List<M4ccbCvDlloMat> findAll() {
        return getJpaController().findM4ccbCvDlloMatEntities();
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String count() {
        return String.valueOf(getJpaController().getM4ccbCvDlloMatCount());
    }
    
}
