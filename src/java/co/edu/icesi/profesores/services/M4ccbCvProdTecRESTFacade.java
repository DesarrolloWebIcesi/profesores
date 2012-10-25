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
@Path("co.edu.icesi.profesores.entities.m4ccbcvprodtec")
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
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public M4ccbCvProdTec find(@PathParam("id") M4ccbCvProdTecPK id) {
        return getJpaController().findM4ccbCvProdTec(id);
    }

    @GET
    @Produces({"application/xml", "application/json"})
    public List<M4ccbCvProdTec> findAll() {
        return getJpaController().findM4ccbCvProdTecEntities();
    }

    @GET
    @Path("{max}/{first}")
    @Produces({"application/xml", "application/json"})
    public List<M4ccbCvProdTec> findRange(@PathParam("max") Integer max, @PathParam("first") Integer first) {
        return getJpaController().findM4ccbCvProdTecEntities(max, first);
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String count() {
        return String.valueOf(getJpaController().getM4ccbCvProdTecCount());
    }
    
}
