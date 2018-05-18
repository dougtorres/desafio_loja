package br.com.desafioconductorws.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.com.desafioconductorws.model.Loja;
import java.util.ArrayList;

public class LojaDAO extends DAO<Loja>{
	
	public Loja read(int id) {
		try {
			Query q = manager
					.createQuery("select a from loja a where a.id= '" + id
							+ "'");
			Loja	 a = (Loja) q.getSingleResult();
			return a;
		} catch (NoResultException e) {
			return null;
		}
	}

	public List<Loja> listarLojas() {
		try {
			Query q = manager
					.createQuery("SELECT a FROM Loja a");
			List<Loja> a = (List<Loja>) q.getResultList();
			return a;
		} catch (NoResultException e) {
			return null;
		}
	}
        
        public Loja buscarLoja(int cnpj) {
		try {
			Query q = manager
					.createQuery("SELECT a FROM Loja a WHERE a.cnpj="+cnpj+"");
			Loja loja = (Loja) q.getSingleResult();
			return loja;
		} catch (NoResultException e) {
			return null;
		}
	}

}
