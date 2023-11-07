package com.projecto.market.persistence.mapper;

import com.projecto.market.domain.PurchaseItemDomain;
import com.projecto.market.persistence.entity.PurchaseProduct;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface PurchaseItemMapper {
    @Mappings({
            @Mapping(source = "id.idProducto", target = "productId"),
            @Mapping(source = "cantidad", target = "quantity"),
            @Mapping(source = "estado",target = "active")
    })
    PurchaseItemDomain toPurchaseItem(PurchaseProduct purchaseProduct);
    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "compra", ignore = true),
            @Mapping(target = "product", ignore = true),
            @Mapping(target = "id.idCompra", ignore = true)
    })
    PurchaseProduct toPurchaseProduct(PurchaseItemDomain purchaseItemDomain);
}
