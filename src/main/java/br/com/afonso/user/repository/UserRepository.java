package br.com.afonso.user.repository;

import br.com.afonso.user.model.User;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.NotFoundException;

import java.util.Optional;

@ApplicationScoped
public class UserRepository implements PanacheRepository<User> {

    @Inject
    EntityManager entityManager;

    @Override
    public void persist(final User user) {
        this.entityManager.persist(user);
    }

    public Optional<User> findByUsername(String username) {
        return this.find("username", username).firstResultOptional();
    }

    public Optional<User> findByDocument(String document) {
        return this.find("document", document).firstResultOptional();
    }

    public User findById(@NotNull Long id) {
        return this.find("id", id).singleResultOptional().orElseThrow(() -> new NotFoundException("Usuário não encontrado"));
    }

}
