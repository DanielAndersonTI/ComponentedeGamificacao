package com.componenteGamificacao;

import java.util.*;

public class Placar {
	private Armazenamento armazenamento;

	public Placar(Armazenamento armazenamento) {
		this.armazenamento = armazenamento;
	}

	public void registrarPontos(String usuario, String tipo, int quantidade) {
		armazenamento.adicionarPontos(usuario, tipo, quantidade);
	}

	public Map<String, Integer> recuperarPontosUsuario(String usuario) {
		Map<String, Integer> pontosUsuario = new HashMap<>();
		Set<String> tiposDePontos = armazenamento.recuperarTiposDePontos();
		for (String tipo : tiposDePontos) {
			pontosUsuario.put(tipo, armazenamento.recuperarPontos(usuario, tipo));
		}
		return pontosUsuario;
	}

	public List<Map.Entry<String, Integer>> ranking(String tipo) {
		Set<String> usuarios = armazenamento.recuperarUsuarios();
		List<Map.Entry<String, Integer>> ranking = new ArrayList<>();

		for (String usuario : usuarios) {
			int pontos = armazenamento.recuperarPontos(usuario, tipo);
			ranking.add(new AbstractMap.SimpleEntry<>(usuario, pontos));
		}

		ranking.sort((entry1, entry2) -> Integer.compare(entry2.getValue(), entry1.getValue()));
		return ranking;
	}
}
