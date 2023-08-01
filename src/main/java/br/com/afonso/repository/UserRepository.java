package br.com.afonso.repository;

import br.com.afonso.model.User;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

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

}
