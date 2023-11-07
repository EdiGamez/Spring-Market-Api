package com.projecto.market.persistence;

import com.projecto.market.domain.PurchaseDomain;
import com.projecto.market.domain.repository.RepositoryPurchase;
import com.projecto.market.persistence.crud.PurchaseCrudRepository;
import com.projecto.market.persistence.entity.Purchase;
import com.projecto.market.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class PurchaseRepository implements RepositoryPurchase {
    @Autowired
    private PurchaseCrudRepository purchaseCrudRepository;
    @Autowired
    private PurchaseMapper mapper;
    @Override
    public List<PurchaseDomain> getAll() {
        return mapper.toPurchases((List<Purchase>) purchaseCrudRepository.findAll());
    }

    @Override
    public Optional<List<PurchaseDomain>> getByClient(String clientId) {
        return purchaseCrudRepository.findByIdCliente(clientId)
                .map(compras -> mapper.toPurchases(compras));
    }

    @Override
    public PurchaseDomain save(PurchaseDomain purchaseDomain) {
        Purchase purchase = mapper.toPurchase(purchaseDomain);
        purchase.getProducts().forEach(product -> product.setCompra(purchase));
        return mapper.toPurchaseDomain(purchaseCrudRepository.save(purchase));
    }
}
