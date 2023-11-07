package com.projecto.market.persistence;

import com.projecto.market.domain.ProductDTO;
import com.projecto.market.domain.repository.ProductRepository;
import com.projecto.market.persistence.crud.ProductCrudRepository;
import com.projecto.market.persistence.entity.Product;
import com.projecto.market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class RepositoryProduct implements ProductRepository {
    @Autowired
    private ProductCrudRepository productCrudRepository;
    @Autowired
    private ProductMapper mapper;
    @Override
    public List<ProductDTO> getAll(){
        List<Product> products = (List<Product>) productCrudRepository.findAll();
        return mapper.toProductsDTO(products);
    }
    @Override
    public Optional<List<ProductDTO>> getByCategory(int idCategory){
        List<Product> products = productCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategory);
        return Optional.of(mapper.toProductsDTO(products));
    }

    @Override
    public Optional<List<ProductDTO>> getScarseProducts(int quantity) {
        Optional<List<Product>> products = productCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        return products.map(products1 -> mapper.toProductsDTO(products1));
    }
    @Override
    public Optional<ProductDTO> getProduct(int idProducto){

        return  productCrudRepository.findById(idProducto).map(product -> mapper.toProductDTO(product));
    }

    @Override
    public ProductDTO save(ProductDTO product) {
        Product product1 = mapper.toProduct(product);
        return mapper.toProductDTO(productCrudRepository.save(product1));
    }

    @Override
    public void delete(int idProducto){
        productCrudRepository.deleteById(idProducto);

    }
}
