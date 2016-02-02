/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.facturacion.fel.queries.model;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author carlosecheverria
 */
@Path("invoice/{issuer}/{acqType}/{acquirer}")
public class InvoiceResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of InvoiceResource
     */
    public InvoiceResource() {
    }

    /**
     * Retrieves representation of an instance of pe.facturacion.fel.queries.model.InvoiceResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        return null;
    }
    
    
    
}
