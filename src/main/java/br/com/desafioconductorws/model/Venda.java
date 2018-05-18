package br.com.desafioconductorws.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Venda {
	@Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cod_venda;
	private double valor;
	private List<Produto> carrinho;
	private Cliente cliente;
	private Vendedor vendedor;
	private String dataVenda;
	
	public Venda(Cliente cliente, List<Produto> carrinho, Vendedor vendedor, String dataVenda) {
		this.valor = 0;
		this.carrinho = carrinho;
		this.cliente = cliente;
		this.vendedor = vendedor;
		this.dataVenda = dataVenda;
	}
	
	public Venda() {}
	
	public double getValor() {
		double valor = 0;
		for(Produto produto : this.carrinho) {
			valor = valor + (produto.getQuantidade() * produto.getValor());
		}
		this.valor = valor;
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public List<Produto> getCarrinho() {
		return carrinho;
	}
	public void setCarrinho(List<Produto> carrinho) {
		this.carrinho = carrinho;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Vendedor getVendedor() {
		return vendedor;
	}
	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	public String getDataVenda() {
		return dataVenda;
	}
	public void setDataVenda(String dataVenda) {
		this.dataVenda = dataVenda;
	}

	public int getCod_venda() {
		return cod_venda;
	}

	public void setCod_venda(int cod_venda) {
		this.cod_venda = cod_venda;
	}
	
	
	

}
