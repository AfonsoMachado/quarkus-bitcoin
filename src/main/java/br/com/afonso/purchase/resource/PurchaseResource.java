package br.com.afonso.purchase.resource;

import br.com.afonso.purchase.model.Purchase;
import br.com.afonso.purchase.service.PurchaseService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.SecurityContext;

import java.util.List;

@Path("/purchases")
public class PurchaseResource {

    @Inject
    PurchaseService purchaseService;

    @POST
    @Transactional
    @RolesAllowed("user")
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(@Context SecurityContext securityContext, Purchase purchase) {
        this.purchaseService.create(securityContext, purchase);
    }

    @GET
    @RolesAllowed("admin")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Purchase> findAllPurchases() {
        return this.purchaseService.findAllPurchases();
    }
}
