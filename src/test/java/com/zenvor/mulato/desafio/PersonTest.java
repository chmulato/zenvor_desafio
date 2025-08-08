package com.zenvor.mulato.desafio;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    @Test
    void testEqualsAndHashCode() {
        Person p1 = new Person("Ana", "12345678900");
        Person p2 = new Person("Ana Paula", "12345678900"); // mesmo CPF
        Person p3 = new Person("Carlos", "98765432100");

        assertEquals(p1, p2, "Pessoas com mesmo CPF devem ser iguais");
        assertEquals(p1.hashCode(), p2.hashCode(), "HashCode deve ser igual para mesmo CPF");
        assertNotEquals(p1, p3, "Pessoas com CPF diferente não devem ser iguais");
    }

    @Test
    void testToString() {
        Person p = new Person("João", "11122233344");
        assertTrue(p.toString().contains("João"));
        assertTrue(p.toString().contains("11122233344"));
    }
}
