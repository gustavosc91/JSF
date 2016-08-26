package br.com.caelum.argentum.modelo;

import java.util.Calendar;

public class CandleBuilder {
	private double abertura;
	private double fechamento;
	private double minimo;
	private double maximo;
	private double volume;
	private Calendar data;
	private boolean aberturaB = false;
	private boolean fechamentoB = false;
	private boolean minimoB = false;
	private boolean maximoB = false;
	private boolean volumeB = false;
	private boolean dataB = false;

	public CandleBuilder comAbertura(double abertura) {
		this.abertura = abertura;
		this.aberturaB = true;
		return this;
	}

	public CandleBuilder comFechamento(double fechamento) {
		this.fechamento = fechamento;
		this.fechamentoB = true;
		return this;
	}

	public CandleBuilder comMinimo(double minimo) {
		this.minimo = minimo;
		this.minimoB = true;
		return this;
	}

	public CandleBuilder comMaximo(double maximo) {
		this.maximo = maximo;
		this.maximoB = true;
		return this;
	}

	public CandleBuilder comVolume(double volume) {
		this.volume = volume;
		this.volumeB = true;
		return this;
	}

	public CandleBuilder comData(Calendar data) {
		this.data = data;
		this.dataB = true;
		return this;
	}

	public boolean valoresSetados() {
		if (aberturaB || fechamentoB || minimoB || maximoB || volumeB || dataB)
			return true;

		return false;
	}

	public Candlestick geraCandle() {

		if (!valoresSetados())
			throw new IllegalArgumentException("Argumentos invalidos");

		return new Candlestick(abertura, fechamento, minimo, maximo, volume,
				data);
	}
}
