/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject11;

import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.*;

/**
 * REST Web Service
 *
 * @author grk
 */
@Path("/coach")
@RequestScoped
public class CoachRESTService {
   @PersistenceContext
   private EntityManager em;


    /**
     * Retrieves representation of an instance of com.mycompany.mavenproject9.PlayerResource
     * @return an instance of com.mycompany.mavenproject9.Coaches
     */
//    @GET
//    @Produces("application/xml")
//    public Coaches getXml() {
//        //TODO return proper representation object
//        throw new UnsupportedOperationException();
//    }

    @GET
    @Produces("application/json")
    public List<Coaches> findAll() {
        //TODO return proper representation object
        List<Coaches> results = em.createNamedQuery("Coaches.findAll").getResultList();
        return results;
    }
    
    /**
     * Sub-resource locator method for {id}
     */
    @GET
    @Path("{id}")
    @Produces("application/json")
    public Coaches getCoachResource(@PathParam("id") Integer id) {
        Query q = em.createNamedQuery("Coaches.findById");
        q.setParameter("id", id);
        Coaches p = (Coaches)q.getSingleResult();
        return p; //"Hello World via getxml!";
    }
    
    @GET
    @Path("{id}/photo")
    @Produces({"image/jpeg", "image/png"})
    public byte[] findWithPhoto(@PathParam("id") Integer id) {
        System.out.println("CoachResource.findWithPhoto(id=" + id + ")");
        Coaches c = getCoachResource(id);
        byte[] photo = c.getPhoto();
        return photo;
    }
    
    /**
     * PUT method for updating or creating an instance of PlayerResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/xml")
    public void putXml(Coaches content) {
    }
}
