package com.techchallenge.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired private ProductRepository repo;

    public List<Product> listAll(){
        return (List<Product>) repo.findAll();
    }

    public void save(Product product) {
        repo.save(product);
    }

    public Product get(String codigo) throws ProductNotFoundException {
        Optional<Product> produto = repo.findById(codigo);

        if(produto.isPresent()){
            return produto.get();
        }

        throw new ProductNotFoundException("Não foi possível encontrar nenhum produto com esse código " + codigo);
    }

    public void delete(String codigo) throws ProductNotFoundException {
        Integer count = repo.countByCodigo(codigo);
        if(count == null || count == 0) {
            throw new ProductNotFoundException("Não foi possível deletar nenhum produto com esse código " + codigo);
        }
        repo.deleteById(codigo);
    }
}
