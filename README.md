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
- `doc/teste.txt` - Enunciado original do teste técnico em inglês
- `doc/teste_anagramas.md` - Especificação completa com templates e exemplos

## Estrutura
```
anagrama-desafio/
  pom.xml                                    # Maven config (Java 11, JUnit 5)
  README.md                                  # Este arquivo
  doc/
    teste.txt                                # Enunciado original do teste técnico
    teste_anagramas.md                       # Especificação detalhada
  src/
    main/java/com/zenvor/mulato/desafio/
      AnagramGenerator.java                  # Implementação principal
      AnagramDemo.java                       # Demonstração prática
    test/java/com/zenvor/mulato/desafio/
      AnagramGeneratorTest.java              # 5 testes unitários JUnit
```

## Executando
Compilar e rodar testes:
```bash
mvn test
```

Demonstração prática:
```bash
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
```bash
# Executar todos os testes
mvn test

# Saída esperada:
# Tests run: 5, Failures: 0, Errors: 0, Skipped: 0
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
Uso livre para fins de avaliação do desafio.

---

## Soluções dos Exercícios Complementares (DSE Test)

O projeto também implementa as soluções para os exercícios complementares do arquivo `doc/dse_test.md`, incluindo:

- **Sobrescrita de equals/hashCode:** Classe `Person` compara por CPF, com testes de igualdade e hashCode.
- **Desacoplamento (Strategy):** Interface `EmailService` e injeção de dependência em `NotificationManager`.
- **Integração de serviços:** Exemplo de `UserService` integrando repositório e envio de e-mail.
- **Prevenção de SQL Injection:** Uso de `PreparedStatement` em `UserDao`.
- **Batch e Diagnóstico:** Classe `BatchProcessor` simula etapas de banco e FTP, com pontos de análise de performance.
- **Consultas SQL simuladas:** Classe `SqlExercise` implementa consultas sobre as tabelas do enunciado, com testes.
- **Gestão de Plantas (XYZ):** Classe `PlantManager` cobre cadastro, atualização, deleção e busca, com regras e permissões.
- **Cadastro de Usuários:** Classe `UserManager` cobre cadastro, atualização, deleção e busca, com validações e testes.

Todos os requisitos do desafio e dos exercícios complementares estão cobertos com código Java, testes unitários e documentação.
