package br.com.afonso.purchase.service;

import br.com.afonso.purchase.dto.CreatePurchaseDto;
import br.com.afonso.purchase.dto.PurchaseDto;
import br.com.afonso.purchase.mappers.PurchaseMapper;
import br.com.afonso.purchase.model.Purchase;
import br.com.afonso.user.model.User;
import br.com.afonso.purchase.repository.PurchaseRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.core.SecurityContext;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class PurchaseService {

    @Inject
    PurchaseRepository purchaseRepository;

    @Inject
    PurchaseMapper purchaseMapper;

    public void create(SecurityContext securityContext, CreatePurchaseDto dto) {
        Optional<User> userOptional = User.findByIdOptional(dto.getUserId());
        User user = userOptional.orElseThrow();

        if (!user.getUsername().equals(securityContext.getUserPrincipal().getName())) {
            throw new RuntimeException("O Usuário logado é diferente do userID");
        }

        Purchase purchase = this.purchaseMapper.toEntity(dto);

        purchase.setStatus("ENVIADA");
        purchaseRepository.persist(purchase);
    }

    public List<PurchaseDto> findAllPurchases() {
        final List<Purchase> purchases = purchaseRepository.listAll();
        return purchaseMapper.entityListToDtoList(purchases);
    }

    public PurchaseDto findById(Long id) {
        final Purchase purchase = this.purchaseRepository.findById(id);
        return this.purchaseMapper.toDto(purchase);
    }

    public void delete(@NotNull Long id) {
        Purchase purchase = this.purchaseRepository.findById(id);
        this.purchaseRepository.delete(purchase);
    }
}
