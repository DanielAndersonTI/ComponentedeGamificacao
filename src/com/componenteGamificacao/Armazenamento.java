package com.componenteGamificacao;

import java.util.*;

public class Armazenamento {
	private Map<String, Map<String, Integer>> dados = new HashMap<>();

	// Método para adicionar pontos
	public void adicionarPontos(String usuario, String tipo, int quantidade) {
		dados.putIfAbsent(usuario, new HashMap<>());
		Map<String, Integer> pontos = dados.get(usuario);
		pontos.put(tipo, pontos.getOrDefault(tipo, 0) + quantidade);
	}

	// Método para obter pontos de um usuário
	public int getPontos(String usuario, String tipo) {
		return dados.getOrDefault(usuario, new HashMap<>()).getOrDefault(tipo, 0);
	}

	// Método para obter os usuários
	public Set<String> getUsuarios() {
		return dados.keySet();
	}

	// Método para obter os tipos de pontos
	public Set<String> getTipos() {
		Set<String> tipos = new HashSet<>();
		for (Map<String, Integer> pontos : dados.values()) {
			tipos.addAll(pontos.keySet());
		}
		return tipos;
	}

	// Método que será mockado no teste
	public Set<String> recuperarTiposDePontos() {
		return getTipos();
	}

	// Método para recuperar os usuários
	public Set<String> recuperarUsuarios() {
		return getUsuarios();
	}

	// Método para recuperar os pontos de um usuário específico
	public int recuperarPontos(String usuario, String tipo) {
		return getPontos(usuario, tipo);
	}
}
