package br.com.desafioconductorws.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cod_prod;
    private String nome;
    private Categoria categ;
    private double valor;
    private int quantidade = 0;

    public Produto(String nome, Categoria categ, double valor, int quantidade) {
        this.nome = nome;
        this.categ = categ;
        this.valor = valor;
        this.quantidade = quantidade;
    }

    public Produto() {
    }

    public int getCod_prod() {
        return cod_prod;
    }

    public void setCod_prod(int cod_prod) {
        this.cod_prod = cod_prod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria getCateg() {
        return categ;
    }

    public void setCateg(Categoria categ) {
        this.categ = categ;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void addUnidade(int quantidade) {
        this.quantidade = this.quantidade + quantidade;
    }

    public void removeUnidade(int quantidade) throws Exception {
        if (quantidade > this.quantidade) {
            throw new Exception("Error: O valor inserido � maior que a quantidade em estoque.");
        }

        this.quantidade = this.quantidade - quantidade;
    }

    public void nextCod_Prod() {
        this.cod_prod++;
    }

}
