package com.zenvor.mulato.desafio;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AnagramGeneratorTest {

    private final AnagramGenerator generator = new AnagramGenerator();

    @Test
    @DisplayName("Deve gerar anagrama único para letra isolada")
    void singleLetter() {
        List<String> out = generator.generate("A");
        assertEquals(List.of("A"), out);
    }

    @Test
    @DisplayName("Deve gerar permutações lexicográficas para 'ABC'")
    void threeLetters() {
        List<String> out = generator.generate("CBA"); // ordem embaralhada para testar sort interno
        assertEquals(List.of("ABC", "ACB", "BAC", "BCA", "CAB", "CBA"), out);
    }

    @Test
    @DisplayName("Deve falhar para vazio")
    void invalidEmpty() {
        assertThrows(IllegalArgumentException.class, () -> generator.generate(""));
        assertThrows(IllegalArgumentException.class, () -> generator.generate("   "));
    }

    @Test
    @DisplayName("Deve falhar para letras repetidas")
    void invalidDuplicate() {
        assertThrows(IllegalArgumentException.class, () -> generator.generate("AAb"));
    }

    @Test
    @DisplayName("Deve falhar para caracter não letra")
    void invalidNonLetter() {
        assertThrows(IllegalArgumentException.class, () -> generator.generate("Ab1"));
        assertThrows(IllegalArgumentException.class, () -> generator.generate("A_b"));
    }
}
