package com.projecto.market.persistence.mapper;

import com.projecto.market.domain.CategoryDTO;
import com.projecto.market.persistence.entity.Category;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mappings({
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "descripcion", target = "category"),
            @Mapping(source = "estado", target = "active")
    })
    CategoryDTO toCategoryDTO(Category category);
    @InheritInverseConfiguration
    @Mapping(target = "products",ignore = true)
    Category toCategory(CategoryDTO categoryDTO);
}
