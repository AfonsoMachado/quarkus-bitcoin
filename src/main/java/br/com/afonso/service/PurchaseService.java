package br.com.afonso.service;

import br.com.afonso.model.Purchase;
import br.com.afonso.model.User;
import br.com.afonso.repository.PurchaseRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.SecurityContext;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class PurchaseService {

    @Inject
    PurchaseRepository purchaseRepository;

    public void create(SecurityContext securityContext, Purchase purchase) {
        Optional<User> userOptional = User.findByIdOptional(purchase.getUserId());
        User user = userOptional.orElseThrow();

        if (!user.getUsername().equals(securityContext.getUserPrincipal().getName())) {
            throw new RuntimeException("O Usuário logado é diferente do userID");
        }

        purchase.setStatus("ENVIADA");
        purchaseRepository.persist(purchase);
    }

    public List<Purchase> findAllPurchases() {
        return purchaseRepository.listAll();
    }
}
