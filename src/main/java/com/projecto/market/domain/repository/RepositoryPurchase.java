package com.projecto.market.domain.repository;

import com.projecto.market.domain.PurchaseDomain;

import java.util.List;
import java.util.Optional;

public interface RepositoryPurchase {
    List<PurchaseDomain> getAll();
    Optional<List<PurchaseDomain>> getByClient(String clientId);
    PurchaseDomain save(PurchaseDomain purchaseDomain);
}
