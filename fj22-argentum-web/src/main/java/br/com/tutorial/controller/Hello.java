package br.com.tutorial.controller;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@RequestScoped
@ManagedBean
public class Hello {

	private String message = "Hello World JSF!";

	@PostConstruct
	public void init() {
		System.out.println(" Bean executado! ");
	}

	public String getMessage() {
		return message+" aquela concatenação";
	}

}