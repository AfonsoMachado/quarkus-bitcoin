package br.com.afonso.repository;

import br.com.afonso.model.Purchase;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

@ApplicationScoped
public class PurchaseRepository implements PanacheRepository<Purchase> {

    @Inject
    EntityManager entityManager;

    @Override
    public void persist(final Purchase purchase) {
        this.entityManager.persist(purchase);
    }
}
