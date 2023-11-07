package com.projecto.market.domain.service;

import com.projecto.market.domain.ProductDTO;
import com.projecto.market.domain.repository.ProductRepository;
import com.projecto.market.persistence.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductDTOService {
    @Autowired
    private ProductRepository productRepository;

    public List<ProductDTO> getAll(){
        return productRepository.getAll();
    }
    public Optional<ProductDTO> getProduct(int productId){
        return productRepository.getProduct(productId);
    }
    public Optional<List<ProductDTO>> getByCategory(int categoryId){
        return  productRepository.getByCategory(categoryId);
    }

    public ProductDTO save(ProductDTO product){
        return productRepository.save(product);
    }
    public boolean delete (int productId){
        return getProduct(productId)
                .map(productDTO -> {
                    productRepository.delete(productId);
                    return true;
                }).orElse( false);    }
}
