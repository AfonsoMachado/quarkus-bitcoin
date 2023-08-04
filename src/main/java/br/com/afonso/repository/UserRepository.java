package br.com.afonso.repository;

import br.com.afonso.model.User;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class UserRepository implements PanacheRepository<User> {

    @Inject
    EntityManager entityManager;

    @Override
    public void persist(final User user) {
        this.entityManager.persist(user);
    }

    public User findByUsername(String username) {
        return this.find("username", username).firstResult();
    }

    public User findByDocument(String document) {
        return this.find("document", document).firstResult();
    }

    public User findById(@NotNull Long id) {
        return this.find("id", id).singleResultOptional().orElseThrow(() -> new NotFoundException("Usuário não encontrado"));
    }

}
