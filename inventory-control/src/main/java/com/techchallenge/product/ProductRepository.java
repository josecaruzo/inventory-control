package com.techchallenge.product;

import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, String> {
    public Integer countByCodigo(String codigo);
}
