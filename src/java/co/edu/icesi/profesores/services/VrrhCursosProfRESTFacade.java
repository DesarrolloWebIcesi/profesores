/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.profesores.services;

import co.edu.icesi.profesores.controllers.VrrhCursosProfJpaController;
import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.naming.InitialContext;
import co.edu.icesi.profesores.entities.VrrhCursosProf;
import java.net.URI;
import java.util.List;
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
 * @author 1130619373
 */
@Path("cursosprof")
public class VrrhCursosProfRESTFacade {

    private EntityManagerFactory getEntityManagerFactory() throws NamingException {
        return Persistence.createEntityManagerFactory("profesoresPU");
    }

    private VrrhCursosProfJpaController getJpaController() {
        try {
            return new VrrhCursosProfJpaController(getEntityManagerFactory());
        } catch (NamingException ex) {
            throw new RuntimeException(ex);
        }
    }

    public VrrhCursosProfRESTFacade() {
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public List<VrrhCursosProf> findByProfessor(@PathParam("id") String id) {
        return getJpaController().findVrrhCursosProfByProfesorCedula(id);
    }
    
    @GET
    @Path("{id}/{period}/{consec}")
    @Produces({"application/xml", "application/json"})
    public List<VrrhCursosProf> findByProfesorPeriod(@PathParam("id") String id) {
        return getJpaController().findVrrhCursosProfByProfesorCedula(id);
    }
    
    @GET
    @Path("current/{id}")
    @Produces({"application/xml", "application/json"})
    public List<VrrhCursosProf> findByProfesorPeriodCurrent(@PathParam("id") String id) {
        return getJpaController().findVrrhCursosProfByProfesorPeriodCurrent(id);
    }
    
    @GET
    @Path("history/{id}")
    @Produces({"application/xml", "application/json"})
    public List<VrrhCursosProf> findByProfesorPeriodHist(@PathParam("id") String id) {
        return getJpaController().findVrrhCursosProfByProfesorPeriodHist(id);
    }

    @GET
    @Produces({"application/xml", "application/json"})
    public List<VrrhCursosProf> findAll() {
        return getJpaController().findVrrhCursosProfEntities();
    }
    
}
