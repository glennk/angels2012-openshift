package com.mycompany.mavenproject11;

import java.util.Collection;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * JAX-RS Example
 *
 * This class produces a RESTful service to read the contents of the members
 * table.
 */
@Path("/player")
@Stateless
public class PlayerRESTService {

    @PersistenceContext
    private EntityManager em;

    @GET
    @Produces("application/json")
    public List<Players> listAllPlayers() {
        // Use @SupressWarnings to force IDE to ignore warnings about "genericizing" the results of
        // this query
        @SuppressWarnings("unchecked")
        // We recommend centralizing inline queries such as this one into @NamedQuery annotations on
        // the @Entity class
        // as described in the named query blueprint:
        // https://blueprints.dev.java.net/bpcatalog/ee5/persistence/namedquery.html
        final List<Players> results = em.createNamedQuery("Players.findAll").getResultList();
        return results;
    }

    /**
     * Sub-resource locator method for {id}
     */
    @GET
    @Path("{id}")
    @Produces("application/json")
    public Players getPlayerResource(@PathParam("id") Integer id) {
        final Players result = (Players) em.createNamedQuery("Players.findByIdplayers").setParameter("idplayers", id).getSingleResult();
        return result;
    }
    
    @GET
    @Path("{id}/photo")
    @Produces({"image/jpeg", "image/png"})
    public byte[] findWithPhoto(@PathParam("id") Integer id) {
        System.out.println("PlayerResource.findWithPhoto(id=" + id + ")");
        Players p = getPlayerResource(id);
        Collection<Photos> ph = p.getPhotosCollection();
        System.out.println("  # of photos returned: " + ph.size());
        if (ph.size() > 0) {
            return ((Photos)ph.toArray()[0]).getFullsize();
        }
        else {
            return null;
        }
    }

}
