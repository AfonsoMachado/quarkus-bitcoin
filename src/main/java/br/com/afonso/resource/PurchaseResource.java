package br.com.afonso.resource;

import br.com.afonso.model.Purchase;
import br.com.afonso.service.PurchaseService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.SecurityContext;

@Path("/purchases")
public class PurchaseResource {

    @Inject
    PurchaseService purchaseService;

    @POST
    @Transactional
    @RolesAllowed("user")
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(SecurityContext securityContext, Purchase purchase) {
        purchaseService.create(securityContext, purchase);
    }
}
