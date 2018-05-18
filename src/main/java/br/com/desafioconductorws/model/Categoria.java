package br.com.desafioconductorws.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Categoria {
	@Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cod_categ;
	private String titulo;

	public Categoria(String titulo) {
		this.titulo = titulo;
	}
	
	public Categoria() {}
	
	public String getTitulo() {
		return this.titulo;
	}

	public int getCod_categ() {
		return cod_categ;
	}

	public void setCod_categ(int cod_categ) {
		this.cod_categ = cod_categ;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	
}
