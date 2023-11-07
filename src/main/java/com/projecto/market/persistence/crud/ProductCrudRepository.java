package com.projecto.market.persistence.crud;

import com.projecto.market.persistence.entity.Product;
import com.projecto.market.persistence.entity.Purchase;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductCrudRepository extends CrudRepository<Product,Integer>{

    List<Product> findByIdCategoriaOrderByNombreAsc(int idCategory);
    Optional<List<Product>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);

 }
