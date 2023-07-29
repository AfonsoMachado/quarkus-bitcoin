package br.com.afonso.resource;

import br.com.afonso.model.Purchase;
import br.com.afonso.repository.PurchaseRepository;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;

@Path("/purchases")
public class PurchaseResource {

    @Inject
    PurchaseRepository purchaseRepository;

    @POST
    @Transactional
    @RolesAllowed("user")
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Purchase purchase) {
        purchase.setStatus("ENVIADA");
        purchaseRepository.persist(purchase);
    }
}
