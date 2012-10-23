/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.profesores.services;

import co.edu.icesi.profesores.controllers.VrrhProCursoAsJpaController;
import co.edu.icesi.profesores.entities.VrrhProCursoAs;
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
@Path("cursosprofpos")
public class VrrhProCursoAsRESTFacade {

    private EntityManagerFactory getEntityManagerFactory() throws NamingException {
        return Persistence.createEntityManagerFactory("profesoresPU");
    }

    private VrrhProCursoAsJpaController getJpaController() {
        try {
            return new VrrhProCursoAsJpaController(getEntityManagerFactory());
        } catch (NamingException ex) {
            throw new RuntimeException(ex);
        }
    }

    public VrrhProCursoAsRESTFacade() {
    }
    
    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public List<VrrhProCursoAs> findByProfessor(@PathParam("id") String id) {
        return getJpaController().findVrrhCursosProfByProfesorCedula(id);
    }
    
    @GET
    @Path("{id}/{period}/{consec}")
    @Produces({"application/xml", "application/json"})
    public List<VrrhProCursoAs> findByProfesorPeriod(@PathParam("id") String id,@PathParam("period") String periodo,@PathParam("consec") int periodoConsecutivo) {
        return getJpaController().findVrrhCursosProfByProfesorPeriod(id, periodo, periodoConsecutivo);
    }
    
    @GET
    @Path("current/{id}")
    @Produces({"application/xml", "application/json"})
    public List<VrrhProCursoAs> findByProfesorPeriodCurrent(@PathParam("id") String id) {
        return getJpaController().findVrrhCursosProfByProfesorPeriodCurrent(id);
    }
    
    @GET
    @Path("history/{id}")
    @Produces({"application/xml", "application/json"})
    public List<VrrhProCursoAs> findByProfesorPeriodHist(@PathParam("id") String id) {
        return getJpaController().findVrrhCursosProfByProfesorPeriodHist(id);
    }

    @GET
    @Produces({"application/xml", "application/json"})
    public List<VrrhProCursoAs> findAll() {
        return getJpaController().findVrrhProCursoAsEntities();
    }
}
