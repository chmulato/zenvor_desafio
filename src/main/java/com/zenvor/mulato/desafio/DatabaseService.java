package com.zenvor.mulato.desafio;

import java.util.Arrays;
import java.util.List;

/**
 * Simulação de serviço de banco de dados para batch.
 */
public class DatabaseService {
    public List<String> fetchData() {
        // Simula busca de dados
        return Arrays.asList("item1", "item2", "item3");
    }
    public String generateFile(String item) {
        // Simula geração de arquivo
        return item + ".txt";
    }
}
