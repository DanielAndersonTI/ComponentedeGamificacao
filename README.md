# Componentes de Gamificação

Este projeto implementa um sistema simples de gamificação que permite registrar e recuperar pontos de diferentes tipos para usuários, além de gerar rankings com base nos pontos.

## Funcionalidades

- **Registrar Pontos**: Permite que um usuário receba pontos de diferentes tipos (ex: "estrela", "moeda", etc.).
- **Recuperar Pontos**: Permite que você consulte os pontos de um usuário para um tipo específico.
- **Ranking de Pontos**: Gera um ranking de usuários baseado na quantidade de pontos de um tipo específico.

## Estrutura do Projeto

- **Classe `Placar`**: Gerencia a lógica de registro e recuperação de pontos, além de gerar rankings.
- **Classe `Armazenamento`**: Responsável por armazenar os dados dos pontos e usuários, simulando um sistema de armazenamento em arquivo.

## Como Usar

1. **Clone o repositório**:

   ```bash
   git clone https://github.com/seu-usuario/repo-de-gamificacao.git
   cd repo-de-gamificacao
