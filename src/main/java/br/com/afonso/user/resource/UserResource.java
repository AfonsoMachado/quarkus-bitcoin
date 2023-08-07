package br.com.afonso.user.resource;

import br.com.afonso.user.dto.CreateUserDto;
import br.com.afonso.user.dto.UserDto;
import br.com.afonso.user.model.User;
import br.com.afonso.user.service.UserService;
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
    public Response create(CreateUserDto dto) {
        this.userService.create(dto);
        return Response.ok("Usuário criado com sucesso").status(201).build();
    }

    @GET
    @RolesAllowed("admin")
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserDto> findAllUsers() {
        return this.userService.findAllUsers();
    }

    @GET
    @RolesAllowed("admin")
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    @Transactional
    public UserDto findById(@PathParam("id") Long id) {
        return this.userService.findById(id);
    }

    @DELETE
    @RolesAllowed("admin")
    @Path("{id}")
    @Transactional
    public Response delete(@PathParam("id") Long id) {
        this.userService.delete(id);
        return Response.ok("Usuário deletado com sucesso").status(202).build();
    }
}
