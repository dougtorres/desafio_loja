/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.desafioconductorws.dao;

import static br.com.desafioconductorws.dao.DAO.manager;
import br.com.desafioconductorws.model.Cliente;
import br.com.desafioconductorws.model.Loja;
import br.com.desafioconductorws.model.Produto;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author Douglas
 */
public class ProdutoDAO extends DAO<Produto> {
    
    public List<Produto> listarProdutos(int cnpj) {
        try {
            Query q = manager
                    .createQuery("SELECT a FROM Loja a WHERE a.cnpj ="+cnpj+"");
            Loja loja = (Loja) q.getSingleResult();
            if(loja != null)
                return loja.getEstoque();
            return null;
        } catch (NoResultException e) {
            return null;
        }
    }
    
    public Produto buscarProduto(String nome, int cnpj) {
		try {
			Query q = manager
					.createQuery("SELECT a FROM Loja a WHERE a.cnpj ="+cnpj+"");
			Loja loja = (Loja) q.getSingleResult();
                        for(Produto produto : loja.getEstoque()){
                            if(produto.getNome().equals(nome)){
                                return produto;
                            }
                        }
			return null;
		} catch (NoResultException e) {
			return null;
		}
	}
    
    public Produto buscarProdutoPorCod(int cod_prod, int cnpj) {
		try {
			Query q = manager
					.createQuery("SELECT a FROM Loja a WHERE a.cnpj ="+cnpj+"");
			Loja loja = (Loja) q.getSingleResult();
                        for(Produto produto : loja.getEstoque()){
                            if(produto.getCod_prod() == cod_prod){
                                return produto;
                            }
                        }
			return null;
		} catch (NoResultException e) {
			return null;
		}
	}
    
}
