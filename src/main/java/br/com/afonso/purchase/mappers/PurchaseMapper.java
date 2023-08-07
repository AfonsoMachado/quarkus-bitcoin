package br.com.afonso.purchase.mappers;

import br.com.afonso.purchase.dto.CreatePurchaseDto;
import br.com.afonso.purchase.dto.PurchaseDto;
import br.com.afonso.purchase.model.Purchase;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface PurchaseMapper {

    Purchase toEntity(CreatePurchaseDto createPurchaseDto);

    PurchaseDto toDto(Purchase purchase);

    List<PurchaseDto> entityListToDtoList(List<Purchase> purchases);
}
