package br.com.afonso.resource;

import br.com.afonso.model.User;
import br.com.afonso.repository.UserRepository;
import br.com.afonso.service.UserService;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/users")
public class UserResource {

    @Inject
    UserService userService;

    @POST
    @PermitAll
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(User user) {
        this.userService.create(user);
        return Response.ok("Usuário criado com sucesso").status(201).build();
    }

    @GET
    @RolesAllowed("admin")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> findAllUsers() {
        return this.userService.findAllUsers();
    }

    @DELETE
    @RolesAllowed("admin")
    @Path("{id}")
    @Transactional
    public Response delete(@PathParam("id") Long id) {
        this.userService.delete(id);
        return Response.ok("Usuário deletado com sucesso").status(201).build();
    }
}
