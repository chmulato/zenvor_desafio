# Prova Técnica – DSE Test

**Nome:** _Christian Vladimir Uhdre Mulato_   **Data:** 08/08/2025

Responda em português ou inglês.

---

## 1. Anagramas em Java

Escreva um programa Java para resolver o seguinte problema:
Você deve criar uma função utilitária para um aplicativo de processamento de texto. A função deve gerar todos os possíveis anagramas de um grupo de letras distintas. Por exemplo, a entrada `{a, b, c}` deve retornar: `abc, acb, bac, bca, cab, cba`.

**Requisitos adicionais:**

- O programa deve aceitar qualquer grupo de letras distintas como entrada e produzir o resultado correto.
- Otimize para legibilidade e clareza.
- Inclua validação básica (ex: garantir que a entrada não seja vazia e contenha apenas letras).
- Escreva testes unitários para validar sua função com pelo menos três casos diferentes, incluindo casos extremos (ex: entrada com uma letra ou vazia).
- Documente seu código explicando a lógica de geração dos anagramas.

---

## 2. Sobrescrita do equals() em Java

Forneça um exemplo de cenário onde é necessário sobrescrever o método `equals()` em Java. Explique os pontos-chave ao implementar esse método, como garantir alinhamento com o método `hashCode()`. Inclua exemplos de código se possível.

---

## 3. Padrão de Projeto para Desacoplamento

Explique como você usaria um padrão de projeto para desacoplar seu código de uma biblioteca de terceiros que pode ser substituída no futuro. Descreva as vantagens e limitações da abordagem escolhida e forneça um pequeno exemplo de código ilustrando sua aplicação.

---

## 4. Experiência com Angular

Descreva sua experiência com Angular, incluindo seus recursos principais e casos de uso. Dê um exemplo prático de aplicação onde utilizou Angular e inclua um trecho de código demonstrando um recurso-chave, como comunicação entre componentes, data binding ou integração de serviços.

---

## 5. Prevenção de SQL Injection

Quais técnicas você utiliza para evitar ataques de SQL injection em aplicações web? Forneça exemplos de código mostrando implementações seguras, como uso de queries parametrizadas ou ORMs. Mencione medidas adicionais para proteger a camada de banco de dados.

---

## 6. Diagnóstico e Otimização de Batch

Descreva os passos que você tomaria para diagnosticar e melhorar a performance de um processo batch que interage com banco de dados e servidor FTP. Explique como identificaria gargalos, otimizaria queries, melhoraria a execução lógica e aumentaria a eficiência da transferência de arquivos. Dê exemplos de ferramentas ou técnicas usadas na análise.

---

## 7. Tabelas para Exercício SQL

### Salesperson

| ID | Name  | Age | Salary |
| -- | ----- | --- | ------ |
| 1  | Abe   | 61  | 140000 |
| 2  | Bob   | 34  | 44000  |
| 5  | Chris | 34  | 40000  |
| 7  | Dan   | 41  | 52000  |
| 8  | Ken   | 57  | 115000 |
| 11 | Joe   | 38  | 38000  |

### Customer

| ID | Name     | City     | Industry Type |
| -- | -------- | -------- | ------------- |
| 4  | Samsonic | Pleasant | J             |
| 6  | Panasung | Oaktown  | J             |
| 7  | Samony   | Jackson  | B             |
| 9  | Orange   | Jackson  | B             |

### Orders

| ID | order_date | customer_id | salesperson_id | Amount |
| -- | ---------- | ----------- | -------------- | ------ |
| 10 | 8/2/96     | 4           | 2              | 540    |
| 20 | 1/30/99    | 4           | 8              | 1800   |
| 30 | 7/14/95    | 9           | 1              | 460    |
| 40 | 1/29/98    | 7           | 2              | 2400   |
| 50 | 2/3/98     | 6           | 7              | 600    |
| 60 | 3/2/98     | 6           | 7              | 720    |
| 70 | 5/6/98     | 9           | 7              | 150    |

---

### Exercícios SQL

a) Retorne os nomes de todos os Salesperson que não têm nenhum pedido com Samsonic.

b) Atualize os nomes dos Salesperson que têm 2 ou mais pedidos. É necessário adicionar um `*` ao final do nome.

c) Delete todos os Salesperson que fizeram pedidos para a cidade de Jackson.

d) O total de vendas para cada Salesperson. Se o vendedor não vendeu nada, mostrar zero.

---

## 8. Sistema XYZ – Fase 1

O cliente possui um sistema chamado XYZ e pretende iniciar atualizações divididas em 3 fases. Os requisitos para a primeira fase são:

1. Permitir novos cadastros de dados no sistema, que servirão de entrada para a segunda fase.
2. Implementar funcionalidades para criar, atualizar, deletar e buscar plantas.
   - Plantas devem ter os seguintes atributos:
     - Código: apenas numérico, obrigatório e único.
     - Descrição: alfanumérica, até 10 caracteres, opcional.
   - Apenas usuários admin podem deletar plantas.
3. Garantir que o sistema previna duplicidade de códigos de plantas.

**Tarefas:**

1. Escreva um caso de uso ou user story para esse cenário, garantindo que atenda claramente aos requisitos.
2. Destaque regras de negócio ou premissas relevantes para a solução.
3. Descreva validações ou medidas de segurança que implementaria no sistema.
4. Sugira como testaria essa funcionalidade, incluindo exemplos de edge cases.

---

## 9. Cadastro de Usuários

**Descrição:**

- Uma tela permite inserir, deletar ou atualizar informações de usuários.
- Cada usuário possui: nome, email, endereço e telefone, sendo nome e email obrigatórios.
- Emails devem ser únicos entre todos os usuários.
- Apenas usuários admin podem deletar outros usuários.

**Tarefas:**

1. Descreva os tipos de testes que implementaria (unitário, integração, end-to-end) e explique os cenários para garantir o funcionamento esperado.
2. Dê exemplos de edge cases e como trataria.
3. Inclua um exemplo de caso de teste em código ou pseudocódigo para um ou mais cenários.

---

DS 1.1
