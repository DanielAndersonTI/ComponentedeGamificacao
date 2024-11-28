package com.componenteGamificacao;

import java.util.*;

public class Armazenamento {
	private Map<String, Map<String, Integer>> dados = new HashMap<>();

	// M�todo para adicionar pontos
	public void adicionarPontos(String usuario, String tipo, int quantidade) {
		dados.putIfAbsent(usuario, new HashMap<>());
		Map<String, Integer> pontos = dados.get(usuario);
		pontos.put(tipo, pontos.getOrDefault(tipo, 0) + quantidade);
	}

	// M�todo para obter pontos de um usu�rio
	public int getPontos(String usuario, String tipo) {
		return dados.getOrDefault(usuario, new HashMap<>()).getOrDefault(tipo, 0);
	}

	// M�todo para obter os usu�rios
	public Set<String> getUsuarios() {
		return dados.keySet();
	}

	// M�todo para obter os tipos de pontos
	public Set<String> getTipos() {
		Set<String> tipos = new HashSet<>();
		for (Map<String, Integer> pontos : dados.values()) {
			tipos.addAll(pontos.keySet());
		}
		return tipos;
	}

	// M�todo que ser� mockado no teste
	public Set<String> recuperarTiposDePontos() {
		return getTipos();
	}

	// M�todo para recuperar os usu�rios
	public Set<String> recuperarUsuarios() {
		return getUsuarios();
	}

	// M�todo para recuperar os pontos de um usu�rio espec�fico
	public int recuperarPontos(String usuario, String tipo) {
		return getPontos(usuario, tipo);
	}
}
