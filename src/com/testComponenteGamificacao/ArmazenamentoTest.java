package com.testComponenteGamificacao;

import org.junit.jupiter.api.*;

import com.componenteGamificacao.Armazenamento;

import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

public class ArmazenamentoTest {

	private Armazenamento armazenamento;
	private File tempFile;

	@BeforeEach
	public void setUp() throws IOException {
		// Cria um arquivo temporário para os testes
		tempFile = File.createTempFile("armazenamentoTest", ".txt");
		tempFile.deleteOnExit(); // Apaga o arquivo após os testes
		armazenamento = new Armazenamento();
	}

	@Test
	public void testAdicionarPontos() {
		armazenamento.adicionarPontos("guerra", "estrela", 10);
		assertEquals(10, armazenamento.getPontos("guerra", "estrela"));
	}

	@Test
	public void testRecuperarPontos() {
		armazenamento.adicionarPontos("guerra", "estrela", 10);
		armazenamento.adicionarPontos("guerra", "moeda", 20);
		assertEquals(10, armazenamento.getPontos("guerra", "estrela"));
		assertEquals(20, armazenamento.getPontos("guerra", "moeda"));
	}

	@Test
	public void testRecuperarUsuarios() {
		armazenamento.adicionarPontos("guerra", "estrela", 10);
		armazenamento.adicionarPontos("fernandes", "estrela", 19);
		assertTrue(armazenamento.getUsuarios().contains("guerra"));
		assertTrue(armazenamento.getUsuarios().contains("fernandes"));
	}

	@Test
	public void testRecuperarTipos() {
		armazenamento.adicionarPontos("guerra", "estrela", 10);
		armazenamento.adicionarPontos("guerra", "moeda", 5);
		assertTrue(armazenamento.getTipos().contains("estrela"));
		assertTrue(armazenamento.getTipos().contains("moeda"));
	}

	@AfterEach
	public void tearDown() {
		// Limpeza dos dados após os testes
	}
}
