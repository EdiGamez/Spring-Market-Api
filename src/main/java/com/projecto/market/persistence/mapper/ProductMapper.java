package com.projecto.market.persistence.mapper;

import com.projecto.market.domain.ProductDTO;
import com.projecto.market.persistence.entity.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})

public interface ProductMapper {
    @Mappings(value = {
            @Mapping(source = "idProducto", target = "productId"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "precioVenta", target = "price"),
            @Mapping(source = "cantidadStock", target = "stock"),
            @Mapping(source = "estado", target = "active"),
            @Mapping(source = "category", target = "categoryDTO")

    })
    ProductDTO toProductDTO(Product product);
    List<ProductDTO> toProductsDTO(List<Product> products);
    @InheritInverseConfiguration
    @Mapping(target = "codigoBarras", ignore = true)
    Product toProduct(ProductDTO productDTO);
}
