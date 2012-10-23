/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.profesores.services;

import co.edu.icesi.profesores.controllers.M4ccbCvLibroJpaController;
import co.edu.icesi.profesores.entities.M4ccbCvLibro;
import co.edu.icesi.profesores.entities.M4ccbCvLibroPK;
import java.util.List;
import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.*;

/**
 *
 * @author 1130619373
 */
@Path("libro")
public class M4ccbCvLibroRESTFacade {

    private EntityManagerFactory getEntityManagerFactory() throws NamingException {
        return Persistence.createEntityManagerFactory("profesoresPU");
    }

    private M4ccbCvLibroJpaController getJpaController() {
        try {
            return new M4ccbCvLibroJpaController(getEntityManagerFactory());
        } catch (NamingException ex) {
            throw new RuntimeException(ex);
        }
    }

    public M4ccbCvLibroRESTFacade() {
    }

    @GET
    @Path("{id}/{professorid}")
    @Produces({"application/xml", "application/json"})
    public M4ccbCvLibro find(@PathParam("id") int id, @PathParam("professorid") String professorId) {
        M4ccbCvLibroPK pk=new M4ccbCvLibroPK("0000", ((Integer)(id)).shortValue(), professorId);
        return getJpaController().findM4ccbCvLibro(pk);
    }

    @GET
    @Produces({"application/xml", "application/json"})
    public List<M4ccbCvLibro> findAll() {
        return getJpaController().findM4ccbCvLibroEntities();
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String count() {
        return String.valueOf(getJpaController().getM4ccbCvLibroCount());
    }
    
}
