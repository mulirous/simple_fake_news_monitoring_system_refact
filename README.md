# Sistema de Monitoramento de Fake News e Qualidade da Informação

Projeto desenvolvido para a disciplina DIM0501 - Boas Práticas de Programação, referente ao Trabalho da Unidade I.

O objetivo do trabalho é refatorar um código original propositalmente mal estruturado, aplicando boas práticas de programação sem reescrever o sistema do zero.

## Funcionalidades

O sistema permite:

- cadastrar notícias manualmente;
- classificar notícias manualmente;
- classificar notícias automaticamente;
- listar notícias cadastradas.

A classificação automática considera critérios simples:

- ausência da palavra `FONTE`;
- presença de linguagem sensacionalista, como `!!!`;
- presença da palavra `URGENTE`;
- texto muito curto.

As classificações possíveis são:

- `confiavel`;
- `duvidosa`;
- `falsa`.

## Estrutura do Projeto

  ```text
  .
  ├── original/
  │   └── Sistema.java
  ├── refactored/
  │   └── src/
  │       ├── Main.java
  │       ├── Sistema.java
  │       ├── Models/
  │       │   ├── News.java
  │       │   └── NewsClassification.java
  │       └── Services/
  │           ├── NewsAnalyzer.java
  │           └── NewsCatalog.java
  └── trabalho_unidade_1_bpp_murilo_costa.md
  ```

  ## Organização do Código Refatorado

  - Main: ponto de entrada da aplicação.
  - Sistema: coordena o fluxo principal do menu e a interação com o usuário.
  - News: representa uma notícia cadastrada.
  - NewsClassification: define as classificações válidas.
  - NewsAnalyzer: aplica os critérios de análise automática.
  - NewsCatalog: gerencia a lista de notícias em memória.

  ## Principais Melhorias Aplicadas

  - Renomeação de classes, métodos e variáveis pouco descritivos.
  - Separação do código em classes com responsabilidades específicas.
  - Encapsulamento dos dados da notícia.
  - Substituição de strings soltas por um enum de classificação.
  - Validação de entradas do usuário.
  - Tratamento de classificações inválidas.
  - Remoção de comentários redundantes.
  - Documentação básica do projeto.

  ## Como Compilar

  A partir da raiz do repositório, execute:

  javac -d /tmp/trab_bpp_classes refactored/src/*.java refactored/src/Models/*.java refactored/src/Services/*.java

  ## Como Executar

  Após compilar, execute:

  java -cp /tmp/trab_bpp_classes Main

  ## Observação Sobre a Refatoração

  O sistema original foi mantido em original/ para comparação. A versão refatorada está em refactored/.

  A refatoração buscou preservar o comportamento principal do sistema original, melhorando sua organização interna, legibilidade, validação e documentação.

