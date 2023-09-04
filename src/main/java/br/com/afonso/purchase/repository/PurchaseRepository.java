package br.com.afonso.purchase.repository;

import br.com.afonso.purchase.model.Purchase;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class PurchaseRepository implements PanacheRepository<Purchase> {

    @Inject
    EntityManager entityManager;

    @Override
    public void persist(final Purchase purchase) {
        this.entityManager.persist(purchase);
    }

    public Purchase findById(@NotNull Long id) {
        return this.find("id", id).singleResultOptional().orElseThrow(() -> new NotFoundException("Compra não encontrada na base de dados"));
    }
}
