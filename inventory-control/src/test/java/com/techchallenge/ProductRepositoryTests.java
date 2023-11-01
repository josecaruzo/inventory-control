package com.techchallenge;

import com.techchallenge.product.Product;
import com.techchallenge.product.ProductRepository;
import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.Assertions;
import org.assertj.core.api.IterableAssert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase( replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false) //false
public class ProductRepositoryTests {
    @Autowired private ProductRepository repo;

    @Test
    public void testAddNew(){
        Product produtoTeste = new Product();

        produtoTeste.setCodigo("CALCAL");
        produtoTeste.setNome("CALCÁRIO CALCÍTICO");
        produtoTeste.setDescricao("Calcário calcítico em pó");
        produtoTeste.setQuant_total((float) 0);
        produtoTeste.setEstoque_min((float)1000);

        Product savedProduct = repo.save(produtoTeste);

        Assertions.assertThat(savedProduct).isNotNull();
        Assertions.assertThat(savedProduct.getCodigo()).isNotNull();
    }

    @Test
    public void testListAll(){
        Iterable<Product> listaProdutos = repo.findAll();

        Assertions.assertThat(listaProdutos).hasSizeGreaterThan(0);

        for (Product produto: listaProdutos){
            System.out.println(produto);
        }
    }

    @Test
    public void testUpdate(){
        String codProduto = "FARMIL"; //Tested with FARMIL1 too
        Optional<Product> optProduto = repo.findById(codProduto);
        Product produtoTeste;

        if (optProduto.isPresent()) {
            produtoTeste = optProduto.get();

            produtoTeste.setDescricao("Farinha de milho granulometria 5mm");
            Product savedProduct = repo.save(produtoTeste);

            Assertions.assertThat(savedProduct.getDescricao()).isEqualTo("Farinha de milho granulometria 5mm");
        }
        else{
            System.out.println("Produto não encontrado");
        }
    }

    @Test
    public void testGet(){
        String codProduto = "FARMIL"; //Tested with FARMIL1 too
        Optional<Product> optProduto = repo.findById(codProduto);
        Assertions.assertThat(optProduto).isPresent();

        System.out.println(optProduto.get());
    }

    @Test
    public void testDelete(){
        String codProduto = "CALCAL";
        repo.deleteById(codProduto);

        Optional<Product> optProduto = repo.findById(codProduto);
        Assertions.assertThat(optProduto).isNotPresent();
    }
}
