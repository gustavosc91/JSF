package br.com.tutorial.controller;

import java.util.Calendar;
import java.util.List;

import javax.annotation.ManagedBean;

import br.com.caelum.argentum.modelo.Negociacao;
import br.com.caelum.argentum.ws.ClienteWebService;

@ManagedBean
public class ArgentumBean {

	private List<Negociacao> negociacoes;

	public ArgentumBean() {
		ClienteWebService cliente = new ClienteWebService();
		this.negociacoes = cliente.getNegociacoes();
	}

	public List<Negociacao> getNegociacoes() {
		return this.negociacoes;
	}

	public double getValor() {
		Calendar data = Calendar.getInstance();
		Negociacao neg = new Negociacao(10, 10, data);
		return neg.getPreco();
	}

}