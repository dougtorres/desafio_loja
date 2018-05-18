package br.com.desafioconductorws.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("P")
public class Cliente extends Usuario {

	public Cliente(String nome, String cpf, String email, String tel) {
		super(nome, cpf, email, tel);

	}

	public Cliente() {}
	
	public String getNome() {
		return super.getNome();
	}

	public String getCpf() {
		return super.getCpf();
	}

	public String getEmail() {
		return super.getEmail();
	}

	public void setEmail(String email) {
		super.setEmail(email);
	}

	public String getTel() {
		return super.getTel();
	}

	public void setTel(String tel) {
		super.setTel(tel);
	}

	public void setNome(String nome) {
		super.setNome(nome);
	}

	public void setCpf(String cpf) {
		super.setCpf(cpf);
	}
	
	

}
