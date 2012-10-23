/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.profesores.services;

import co.edu.icesi.profesores.controllers.M4ccbCvSoftRegJpaController;
import co.edu.icesi.profesores.entities.M4ccbCvSoftReg;
import co.edu.icesi.profesores.entities.M4ccbCvSoftRegPK;
import java.util.List;
import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.*;

/**
 *
 * @author 1130619373
 */
@Path("softreg")
public class M4ccbCvSoftRegRESTFacade {

    private EntityManagerFactory getEntityManagerFactory() throws NamingException {
        return Persistence.createEntityManagerFactory("profesoresPU");
    }

    private M4ccbCvSoftRegJpaController getJpaController() {
        try {
            return new M4ccbCvSoftRegJpaController(getEntityManagerFactory());
        } catch (NamingException ex) {
            throw new RuntimeException(ex);
        }
    }

    public M4ccbCvSoftRegRESTFacade() {
    }

    @GET
    @Path("{id}/{professorid}")
    @Produces({"application/xml", "application/json"})
    public M4ccbCvSoftReg find(@PathParam("id") int id, @PathParam("professorid") String professorId) {
        M4ccbCvSoftRegPK pk = new M4ccbCvSoftRegPK("0000", ((Integer)(id)).shortValue(), professorId);
        return getJpaController().findM4ccbCvSoftReg(pk);
    }

    @GET
    @Produces({"application/xml", "application/json"})
    public List<M4ccbCvSoftReg> findAll() {
        return getJpaController().findM4ccbCvSoftRegEntities();
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String count() {
        return String.valueOf(getJpaController().getM4ccbCvSoftRegCount());
    }
    
}
