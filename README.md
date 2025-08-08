# Anagrama Desafio

Gerador de anagramas (permutações) de uma palavra com letras distintas usando backtracking.

## Solução do Teste Técnico

Este projeto implementa a solução completa para o teste técnico localizado em `doc/teste.txt`.

**Requisitos Atendidos:**

- Função Java que gera todos os anagramas possíveis de letras distintas
- Aceita qualquer grupo de letras distintas como entrada
- Otimizado para legibilidade e clareza (código documentado)
- Validação básica (entrada não vazia, apenas letras, letras distintas)
- Testes unitários com 5 casos (incluindo edge cases)
- Documentação clara explicando a lógica de geração

**Exemplo do Problema:** `{a, b, c}` → `abc, acb, bac, bca, cab, cba`

## Regras

- Entrada: apenas letras ASCII (a-z ou A-Z)
- Case-insensitive para verificação de duplicidade
- Todas as letras devem ser distintas
- Tamanho máximo: 10 caracteres (10! = 3.628.800)

## Algoritmo e Complexidade

**Abordagem:** Backtracking recursivo

- Validação de entrada rigorosa
- Ordenação prévia para saída lexicográfica determinística
- Rastreamento de letras usadas com boolean array
- Construção incremental com StringBuilder

**Complexidade:**

- Tempo: O(n × n!) onde n = tamanho da palavra (n! permutações com custo O(n) para construir cada string)
- Espaço: O(n) para a pilha de recursão + O(n) para estruturas auxiliares (desconsiderando a saída)

## Documentação Adicional

- `doc/dse_test.md` - Enunciado dos exercícios complementares (DSE Test)
- `doc/dse_test.docx` - Versão Word do enunciado DSE
- `doc/dse_test_original.docx` - Versão original do enunciado
- `doc/solucao.md` - Análise detalhada da solução + respostas exercícios
- `doc/solucao.docx` - Versão Word da solução
- `doc/solucao.pdf` - Versão PDF da solução
- `doc/dominio.md` - Informações de domínio estruturadas

## Estrutura

```
zenvor_desafio/
  pom.xml                                      # Config Maven (Java 11, JUnit 5)
  README.md                                    # Documentação principal
  LICENSE                                      # Licença MIT
  .gitignore                                   # Configuração Git
  doc/
    dse_test.md                                # Enunciado dos exercícios complementares (DSE Test)
    dse_test.docx                              # Versão Word do enunciado DSE
    dse_test_original.docx                     # Versão original do enunciado
    solucao.md                                 # Análise detalhada da solução + respostas exercícios
    solucao.docx                               # Versão Word da solução
    solucao.pdf                                # Versão PDF da solução
    dominio.md                                 # Informações de domínio estruturadas
  target/                                      # Artefatos de build (gerado pelo Maven)
    zen-anagramas-solution.jar                 # Artefato gerado (v1.0.0-SNAPSHOT)
  src/
    main/java/com/zenvor/mulato/desafio/
      AnagramGenerator.java                    # Gerador de anagramas (backtracking)
      AnagramDemo.java                         # Execução demonstrativa
      Person.java                              # Exemplo equals/hashCode por CPF
      User.java                                # Modelo de usuário
      EmailService.java                        # Interface para serviço de email
      SmtpEmailService.java                    # Implementação SMTP do serviço de email
      NotificationManager.java                 # Desacoplamento via Strategy de EmailService
      UserService.java                         # Integração repositório + envio de notificação
      UserRepository.java                      # Interface de repositório de usuários
      UserDao.java                             # Implementação DAO segura (PreparedStatement)
      DatabaseService.java                     # Serviço de banco de dados
      FtpService.java                          # Serviço FTP
      BatchProcessor.java                      # Simulação de processo batch (diagnóstico)
      SqlExercise.java                         # Lógica simulando consultas SQL do enunciado
      PlantManager.java                        # Gestão de plantas (regras e permissões)
      UserManager.java                         # Gestão de usuários (validações e permissões)
    test/java/com/zenvor/mulato/desafio/
      AnagramGeneratorTest.java                # Testes do gerador de anagramas
      PersonTest.java                          # Testes equals/hashCode
      NotificationManagerTest.java             # Testes de desacoplamento
      UserServiceTest.java                     # Testes de integração simples
      BatchProcessorTest.java                  # Testes do processo batch
      SqlExerciseTest.java                     # Testes das consultas simuladas
      PlantManagerTest.java                    # Testes das regras de plantas
      UserManagerTest.java                     # Testes das regras de usuários
```

## Executando

Compilar e rodar testes:

```powershell
mvn test
```

Demonstração prática:

```powershell
mvn compile
mvn exec:java -Dexec.mainClass="com.zenvor.mulato.desafio.AnagramDemo"
```

Ou alternativamente:

```powershell
mvn compile
java -cp target\classes com.zenvor.mulato.desafio.AnagramDemo
```

## Exemplo

```java
AnagramGenerator gen = new AnagramGenerator();

// Casos do teste técnico
System.out.println(gen.generate("abc"));    // [abc, acb, bac, bca, cab, cba]
System.out.println(gen.generate("a"));      // [a]
System.out.println(gen.generate("AB"));     // [AB, BA]

// Caso mais complexo
System.out.println(gen.generate("ABCD"));   // 24 permutações
```

## Validação e Testes

```powershell
# Executar todos os testes
mvn test

# Executar com output detalhado
mvn test -Dtest.verbose=true

# Executar testes específicos
mvn test -Dtest=AnagramGeneratorTest
```

**Casos de Teste Implementados:**

1. `singleLetter()` - Letra única: "A" → ["A"]
2. `threeLetters()` - Três letras: "CBA" → 6 permutações ordenadas
3. `invalidEmpty()` - Entrada vazia/espaços → IllegalArgumentException
4. `invalidDuplicate()` - Letras repetidas: "AAb" → IllegalArgumentException
5. `invalidNonLetter()` - Caracteres inválidos: "Ab1", "A_b" → IllegalArgumentException

## Possíveis Extensões

- Suportar letras repetidas gerando permutações únicas (requires skip de duplicados)
- Stream para evitar materializar tudo em memória
- Cache para subproblemas (não necessário para letras distintas)

## Licença

Este projeto está licenciado sob a Licença MIT - veja o arquivo [LICENSE](LICENSE) para detalhes.

---

## Soluções dos Exercícios Complementares (DSE Test)

O projeto também implementa as soluções para os exercícios complementares do arquivo `doc/dse_test.md`, incluindo:

- **Sobrescrita de equals/hashCode:** Classe `Person` compara por CPF, com testes de igualdade e hashCode.
- **Desacoplamento (Strategy):** Interface `EmailService` e implementação `SmtpEmailService` com injeção de dependência em `NotificationManager`.
- **Integração de serviços:** Exemplo de `UserService` integrando repositório e envio de e-mail.
- **Prevenção de SQL Injection:** Uso de `PreparedStatement` em `UserDao` e `DatabaseService`.
- **Batch e Diagnóstico:** Classe `BatchProcessor` simula etapas de banco e FTP, com pontos de análise de performance.
- **Consultas SQL simuladas:** Classe `SqlExercise` implementa consultas sobre as tabelas do enunciado, com testes.
- **Gestão de Plantas (XYZ):** Classe `PlantManager` cobre cadastro, atualização, deleção e busca, com regras e permissões.
- **Cadastro de Usuários:** Classe `UserManager` cobre cadastro, atualização, deleção e busca, com validações e testes.

## Tecnologias e Ferramentas

- **Java 11** - Linguagem principal
- **Maven 3.x** - Gerenciamento de dependências e build
- **JUnit 5** - Framework de testes unitários
- **Git** - Controle de versão
- **Windows PowerShell** - Shell padrão para execução

## Arquitetura

O projeto segue princípios de Clean Code e SOLID:

- **Single Responsibility:** Cada classe tem uma responsabilidade específica
- **Strategy Pattern:** `EmailService` permite diferentes implementações de envio
- **Repository Pattern:** `UserRepository` abstrai acesso a dados
- **Dependency Injection:** Interfaces injetadas via construtor
- **Separation of Concerns:** Lógica de negócio separada de infraestrutura

Todos os requisitos do desafio e dos exercícios complementares estão cobertos com código Java, testes unitários e documentação.

## Desenvolvimento

### Pré-requisitos

- Java 11 ou superior
- Maven 3.6+
- Git
- IDE (recomendado: IntelliJ IDEA ou Eclipse)

### Setup do Ambiente

```powershell
# Clonar o repositório
git clone <repo-url>
cd zenvor_desafio

# Compilar o projeto
mvn clean compile

# Executar todos os testes
mvn test

# Gerar artefato
mvn package
```

### Estrutura de Commits

O projeto segue um padrão de commits descritivos:

- `feat:` para novas funcionalidades
- `fix:` para correções de bugs
- `docs:` para atualizações de documentação
- `test:` para adição/atualização de testes
- `refactor:` para refatorações de código

---

**Autor:** Desenvolvido como solução para o teste técnico Zenvor
**Versão:** 1.0.0-SNAPSHOT
**Data:** Campo Largo, PR, sexta-feira, 08 de Agosto 2025.
