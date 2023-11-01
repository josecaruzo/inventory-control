package com.techchallenge.product;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "produtos")
public class Product {
    @Id
    @Column(length = 15, nullable = false, unique = true)
    private String codigo;
    @Column(length =  50, nullable = false, unique = true)
    private String nome;

    @Column(length = 200, nullable = true)
    private String descricao;

    @Column(nullable = false)
    private Float quant_total;

    @Column(nullable = false)
    private Float estoque_min;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Float getQuant_total() {
        return quant_total;
    }

    public void setQuant_total(Float quant_total) {
        this.quant_total = quant_total;
    }

    public Float getEstoque_min() {
        return estoque_min;
    }

    public void setEstoque_min(Float estoque_min) {
        this.estoque_min = estoque_min;
    }

    @Override
    public String toString() {
        return "Product{" +
                "codigo='" + codigo + '\'' +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", quant_total=" + quant_total +
                ", estoque_min=" + estoque_min +
                '}';
    }
}
