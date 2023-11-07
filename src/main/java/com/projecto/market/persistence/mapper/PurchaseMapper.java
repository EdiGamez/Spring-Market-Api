package com.projecto.market.persistence.mapper;

import com.projecto.market.domain.PurchaseDomain;
import com.projecto.market.persistence.entity.Purchase;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PurchaseItemMapper.class})
public interface PurchaseMapper {
    @Mappings({
            @Mapping(source="idCompra",target="purchaseId"),
            @Mapping(source="idCliente",target="clientId"),
            @Mapping(source="fecha",target="date"),
            @Mapping(source="medioPago",target="paymentMethod"),
            @Mapping(source="comentario",target="comment"),
            @Mapping(source="estado",target="state"),
            @Mapping(source="products",target="items")
    })
    PurchaseDomain toPurchaseDomain(Purchase purchase);
    List<PurchaseDomain> toPurchases(List<Purchase> purchases);
    @InheritInverseConfiguration
    @Mapping(target = "client", ignore = true)
    Purchase toPurchase(PurchaseDomain purchaseDomain);
}
