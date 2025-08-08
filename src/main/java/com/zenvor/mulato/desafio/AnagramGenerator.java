package com.zenvor.mulato.desafio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Gera todos os anagramas (permutações) de uma palavra composta por letras distintas.
 * Requisitos:
 *  - Apenas letras ASCII a-z ou A-Z
 *  - Todas distintas (case-insensitive)
 *  - Tamanho máximo de 10 caracteres (limite prático para 10! = 3.628.800)
 */
public class AnagramGenerator {

    /**
     * Gera a lista de anagramas em ordem lexicográfica.
     * @param word palavra de entrada
     * @return lista imutável com todos os anagramas
     * @throws IllegalArgumentException se a palavra for inválida
     */
    public List<String> generate(String word) {
        validate(word);
        if (word.length() <= 1) {
            return Collections.singletonList(word);
        }
        char[] chars = word.toCharArray();
        Arrays.sort(chars); // facilita gerar já em ordem lexicográfica
        boolean[] used = new boolean[chars.length];
        StringBuilder current = new StringBuilder();
        List<String> result = new ArrayList<>();
        backtrack(chars, used, current, result);
        return Collections.unmodifiableList(result);
    }

    /**
     * Valida as regras de entrada.
     */
    void validate(String word) {
        if (word == null || word.isBlank()) {
            throw new IllegalArgumentException("Palavra não pode ser vazia");
        }
        if (word.length() > 10) {
            throw new IllegalArgumentException("Palavra excede tamanho máximo de 10");
        }
        boolean[] seen = new boolean[52]; // 26 lower + 26 upper (tratando case-insensitive com índice normalizado)
        for (char c : word.toCharArray()) {
            if (!isAsciiLetter(c)) {
                throw new IllegalArgumentException("Caracter inválido: " + c);
            }
            int idx = Character.toLowerCase(c) - 'a';
            if (seen[idx]) {
                throw new IllegalArgumentException("Letras devem ser distintas (case-insensitive)");
            }
            seen[idx] = true;
        }
    }

    private boolean isAsciiLetter(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    /**
     * Backtracking clássico para permutações sem repetição.
     */
    void backtrack(char[] chars, boolean[] used, StringBuilder current, List<String> result) {
        if (current.length() == chars.length) {
            result.add(current.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (used[i]) continue;
            // Pruning de duplicados se houvesse caracteres repetidos (não ocorre aqui após validação)
            used[i] = true;
            current.append(chars[i]);
            backtrack(chars, used, current, result);
            current.deleteCharAt(current.length() - 1);
            used[i] = false;
        }
    }
}
