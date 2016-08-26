package br.com.caelum.argentum.modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CandlestickFactory {

	public Candlestick constroiCandleParaData(Calendar data,
			List<Negociacao> negociacoes) {
		CandleBuilder builder = new CandleBuilder();

		double maximo = 0;

		double minimo = Double.MAX_VALUE;

		builder.comAbertura(negociacoes.isEmpty() ? 0 : negociacoes.get(0)
				.getPreco());
		builder.comFechamento(negociacoes.isEmpty() ? 0 : negociacoes.get(
				negociacoes.size() - 1).getPreco());

		double volume = 0;

		for (Negociacao negociacao : negociacoes) {
			volume += negociacao.getVolume();

			if (negociacao.getPreco() > maximo) {
				maximo = negociacao.getPreco();
			}
			if (negociacao.getPreco() < minimo) {
				minimo = negociacao.getPreco();
			}

		}
		if (minimo == Double.MAX_VALUE) {
			minimo = 0;
		}

		builder.comVolume(volume);
		builder.comMaximo(maximo);
		builder.comMinimo(minimo);
		builder.comData(data);

		return builder.geraCandle();

	}

	public List<Candlestick> constroiCandles(List<Negociacao> negociacoes) {
		List<Candlestick> candles = new ArrayList<Candlestick>();
		List<Negociacao> negociacoesDoDia = new ArrayList<Negociacao>();
		Calendar data = negociacoes.get(0).getData();

		for (Negociacao negociacao : negociacoes) {
			if (negociacao.getData().before(data))
				throw new IllegalStateException("negociações em ordem errada");

			if (!negociacao.isMesmoDia(data)) {

				Candlestick doDia = constroiCandleParaData(data,
						negociacoesDoDia);

				candles.add(doDia);

				negociacoesDoDia = new ArrayList<Negociacao>();
				data = negociacao.getData();
			}
			negociacoesDoDia.add(negociacao);
		}
		Candlestick doDia = constroiCandleParaData(data, negociacoesDoDia);
		candles.add(doDia);
		return candles;
	}

}
