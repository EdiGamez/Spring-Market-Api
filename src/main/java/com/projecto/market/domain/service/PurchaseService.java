package com.projecto.market.domain.service;

import com.projecto.market.domain.PurchaseDomain;
import com.projecto.market.persistence.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {
    @Autowired

    private PurchaseRepository purchaseRepository;

    public List<PurchaseDomain> getAll(){
        if (purchaseRepository.getAll() != null){
            return purchaseRepository.getAll();
        }
        else{
            System.out.println("Si es null");
            return  null;
        }

    }
    public Optional<List<PurchaseDomain>> getByClient(String clientId) {
        return purchaseRepository.getByClient(clientId);
    }

    public PurchaseDomain save(PurchaseDomain purchase) {
        return purchaseRepository.save(purchase);
    }
}
