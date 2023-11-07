package com.projecto.market.persistence.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "categorias")
public class Category {
    @Id
    @Column(name = "id_categoria")
    private  Integer idCategoria;
    private String descripcion;
    private Boolean estado;
    @OneToMany(mappedBy = "category")
    private List<Product> products;
    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

}
