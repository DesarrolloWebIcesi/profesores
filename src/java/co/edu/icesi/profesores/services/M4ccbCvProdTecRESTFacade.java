/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.profesores.services;

import co.edu.icesi.profesores.controllers.M4ccbCvProdTecJpaController;
import co.edu.icesi.profesores.entities.M4ccbCvProdTec;
import co.edu.icesi.profesores.entities.M4ccbCvProdTecPK;
import java.util.List;
import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author 14620701
 */
@Path("prodtec")
public class M4ccbCvProdTecRESTFacade {

    private EntityManagerFactory getEntityManagerFactory() throws NamingException {
         return Persistence.createEntityManagerFactory("profesoresPU");
    }

    private M4ccbCvProdTecJpaController getJpaController() {
        try {
            return new M4ccbCvProdTecJpaController(getEntityManagerFactory());
        } catch (NamingException ex) {
            throw new RuntimeException(ex);
        }
    }

    public M4ccbCvProdTecRESTFacade() {
    }  

    @GET
    @Path("{id}/{professorid}")
    @Produces({"application/xml", "application/json"})
    public M4ccbCvProdTec find(@PathParam("id") int id, @PathParam("professorid") String professorId) {
        M4ccbCvProdTecPK pk=new M4ccbCvProdTecPK("0000", ((Integer)(id)).shortValue(), professorId);
        return getJpaController().findM4ccbCvProdTec(pk);
    }

    @GET
    @Produces({"application/xml", "application/json"})
    public List<M4ccbCvProdTec> findAll() {
        return getJpaController().findM4ccbCvProdTecEntities();
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String count() {
        return String.valueOf(getJpaController().getM4ccbCvProdTecCount());
    }
    
}
