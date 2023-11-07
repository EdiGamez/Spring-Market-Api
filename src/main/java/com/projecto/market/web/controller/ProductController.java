package com.projecto.market.web.controller;

import com.projecto.market.domain.ProductDTO;
import com.projecto.market.domain.service.ProductDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductDTOService productDTOService;
    @GetMapping("/all")
    public ResponseEntity<List<ProductDTO>> getAll() {
        return new ResponseEntity<>(productDTOService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProduct( @PathVariable("id") int productId){
        return productDTOService.getProduct(productId).map(productDTO -> new ResponseEntity<>(productDTO,HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/category/{categoryid}")
    public ResponseEntity<List<ProductDTO>> getByCategory(@PathVariable("categoryid") int categoryId){
        return productDTOService.getByCategory(categoryId).map(productDTOS -> new ResponseEntity<>(productDTOS, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping("/save")
    public ResponseEntity<ProductDTO> save(@RequestBody ProductDTO productDTO){

        return new ResponseEntity<>(productDTOService.save(productDTO),HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") int productId){
        if(productDTOService.delete(productId)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }

}
