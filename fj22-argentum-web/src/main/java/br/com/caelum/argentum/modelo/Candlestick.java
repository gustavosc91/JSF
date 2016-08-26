package br.com.caelum.argentum.modelo;

import java.util.Calendar;

public final class Candlestick {
	private final double abertura;
	private final double fechamento;
	private final double minimo;
	private final double maximo;
	private final double volume;
	private final Calendar data;

	public Candlestick(double abertura, double fechamento, double minimo,
			double maximo, double volume, Calendar data) {
		if (abertura < 0 || fechamento < 0 || minimo < 0 || maximo < 0
				|| volume < 0)
			throw new IllegalArgumentException("Valor negativo");
		if (data == null)
			throw new IllegalArgumentException("data nao pode ser nula");

		this.abertura = abertura;
		this.fechamento = fechamento;
		this.minimo = minimo;
		this.maximo = maximo;
		this.volume = volume;
		this.data = data;
	}

	public boolean isAlta() {
		return this.abertura <= this.fechamento;
	}

	public boolean isBaixa() {
		return this.abertura > this.fechamento;
	}

	public double getAbertura() {
		return abertura;
	}

	public double getFechamento() {
		return fechamento;
	}

	public double getMinimo() {
		return minimo;
	}

	public double getMaximo() {
		return maximo;
	}

	public double getVolume() {
		return volume;
	}

	public Calendar getData() {
		return data;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		builder.append(this.abertura);
		builder.append(", ");
		builder.append(this.fechamento);
		builder.append(", ");
		builder.append(this.minimo);
		builder.append(", ");
		builder.append(this.maximo);
		builder.append(", ");
		builder.append(this.volume);
		builder.append(", ");

		builder.append(data.get(Calendar.DAY_OF_MONTH) + "/"
				+ data.get(Calendar.MONTH) + "/" + data.get(Calendar.YEAR));
		builder.append("]");

		return builder.toString();
	}

}
