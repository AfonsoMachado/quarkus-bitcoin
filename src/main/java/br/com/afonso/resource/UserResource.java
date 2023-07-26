package br.com.afonso.resource;

import br.com.afonso.model.User;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;

@Path("/users")
public class UserResource {

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(User user) {
        User.persist(user);
    }
}
