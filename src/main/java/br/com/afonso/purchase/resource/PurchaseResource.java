package br.com.afonso.purchase.resource;

import br.com.afonso.purchase.dto.CreatePurchaseDto;
import br.com.afonso.purchase.dto.PurchaseDto;
import br.com.afonso.purchase.model.Purchase;
import br.com.afonso.purchase.service.PurchaseService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
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
    public Response create(@Context SecurityContext securityContext, CreatePurchaseDto purchase) {
        this.purchaseService.create(securityContext, purchase);
        return Response.ok("Compra criada com sucesso").status(201).build();
    }

    @GET
    @RolesAllowed("admin")
    @Produces(MediaType.APPLICATION_JSON)
    public List<PurchaseDto> findAllPurchases() {
        return this.purchaseService.findAllPurchases();
    }

    @GET
    @RolesAllowed("admin")
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    @Transactional
    public PurchaseDto findById(@PathParam("id") Long id) {
        return this.purchaseService.findById(id);
    }

    @DELETE
    @RolesAllowed("admin")
    @Path("{id}")
    @Transactional
    public Response delete(@PathParam("id") Long id) {
        this.purchaseService.delete(id);
        return Response.ok("Compra deletada com sucesso!").status(200).build();
    }
}
