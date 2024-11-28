package com.testComponenteGamificacao;

import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.componenteGamificacao.Armazenamento;
import com.componenteGamificacao.Placar;

import java.util.*;

public class PlacarTest {
	private Placar placar;
	private Armazenamento armazenamentoMock;

	@BeforeEach
	public void setUp() {
		// Criando o mock do Armazenamento
		armazenamentoMock = mock(Armazenamento.class);
		// Inicializando o objeto Placar com o mock
		placar = new Placar(armazenamentoMock);
	}

	@Test
	public void testRegistrarPontos() {
		// Simulando a interação com o mock
		placar.registrarPontos("guerra", "estrela", 10);

		// Verificando se o método 'adicionarPontos' foi chamado corretamente
		verify(armazenamentoMock).adicionarPontos("guerra", "estrela", 10);
	}

	@Test
	public void testRecuperarPontosUsuario() {
		// Simulando o comportamento do mock para recuperar tipos de pontos e valores
		when(armazenamentoMock.recuperarTiposDePontos()).thenReturn(Set.of("estrela", "moeda"));
		when(armazenamentoMock.recuperarPontos("guerra", "estrela")).thenReturn(25);
		when(armazenamentoMock.recuperarPontos("guerra", "moeda")).thenReturn(10);

		// Chamando o método que usa o mock
		Map<String, Integer> pontos = placar.recuperarPontosUsuario("guerra");

		// Verificando os resultados
		assertEquals(2, pontos.size());
		assertEquals(25, pontos.get("estrela"));
		assertEquals(10, pontos.get("moeda"));
	}

	@Test
	public void testRanking() {
		// Simulando o comportamento do mock para recuperar usuários e pontos
		when(armazenamentoMock.recuperarUsuarios()).thenReturn(Set.of("guerra", "fernandes"));
		when(armazenamentoMock.recuperarPontos("guerra", "estrela")).thenReturn(25);
		when(armazenamentoMock.recuperarPontos("fernandes", "estrela")).thenReturn(15);

		// Chamando o método que retorna o ranking
		List<Map.Entry<String, Integer>> ranking = placar.ranking("estrela");

		// Verificando o tamanho do ranking e a ordenação dos usuários
		assertEquals(2, ranking.size());
		assertEquals("guerra", ranking.get(0).getKey());
		assertEquals(25, ranking.get(0).getValue());
		assertEquals("fernandes", ranking.get(1).getKey());
		assertEquals(15, ranking.get(1).getValue());
	}
}
