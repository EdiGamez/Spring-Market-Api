package com.projecto.market.persistence.crud;

import com.projecto.market.domain.PurchaseDomain;
import com.projecto.market.persistence.entity.Purchase;
import com.projecto.market.persistence.entity.PurchaseProduct;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PurchaseCrudRepository extends CrudRepository<Purchase, Integer> {
    Optional<List<Purchase>> findByIdCliente(String idCliente);
}
