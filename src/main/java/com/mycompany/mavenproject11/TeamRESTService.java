/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject11;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;

/**
 * REST Web Service
 *
 * @author grk
 */
@Path("/team")
@Stateless
public class TeamRESTService {
   @PersistenceContext
   private EntityManager em;

    @GET
    @Produces("application/json")
    public List<Teams> findAll() {
        //TODO return proper representation object
        final List<Teams> results = em.createNamedQuery("Teams.findAll").getResultList();
        return results;
    }
    
    /**
     * Sub-resource locator method for {id}
     */
    @GET
    @Path("{id}")
    @Produces("application/json")
    public Teams getTeamResource(@PathParam("id") Integer id) {
        Teams t = em.find(Teams.class, id);
        return t; //"Hello World via getxml!";
    }
    
    /**
     * Sub-resource locator method for {id}
     */
    @GET
    @Path("{id}/players")
    @Produces("application/json")
    public List<Players> getPlayersForTeamResource(@PathParam("id") Integer id) {
        Teams t = em.find(Teams.class, id);
        Query q2 = em.createNamedQuery("Players.findAllActiveByTeamId");
        q2.setParameter("team", t);
        List <Players> pl = q2.getResultList();
        return pl;
    }
    
    /**
     * PUT method for updating or creating an instance of PlayerResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/xml")
    public void putXml(Players content) {
    }
}
