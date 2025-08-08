package com.zenvor.mulato.desafio;

/**
 * Classe de exemplo para testar o AnagramGenerator manualmente.
 */
public class AnagramDemo {
    public static void main(String[] args) {
        AnagramGenerator generator = new AnagramGenerator();
        
        // Casos de teste
        System.out.println("=== Teste com 'abc' ===");
        System.out.println(generator.generate("abc"));
        
        System.out.println("\n=== Teste com 'AB' ===");
        System.out.println(generator.generate("AB"));
        
        System.out.println("\n=== Teste com 'x' ===");
        System.out.println(generator.generate("x"));
        
        System.out.println("\n=== Teste com 'ABCD' ===");
        System.out.println("Total permutações: " + generator.generate("ABCD").size());
    }
}
