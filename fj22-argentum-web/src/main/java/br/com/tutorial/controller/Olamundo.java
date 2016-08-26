package br.com.tutorial.controller;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@RequestScoped
@ManagedBean
public class Olamundo {
	private String mensagem = "Essa mensagem é da classe ola mundo";
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@PostConstruct
	public void init() {
		System.out.println(" Execução ");
	}

	public String getMensagem() {
		return mensagem;
	}

	public void nomeFoiDigitado() {
		System.out.println("\nChamou o botão"+nome);
	}
}
