package com.zenvor.mulato.desafio;

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class SqlExerciseTest {
    @Test
    void testSalespersonsWithoutSamsonic() {
        List<String> result = SqlExercise.salespersonsWithoutSamsonic();
        // Bob e Ken têm pedidos com Samsonic (customer_id=4)
        assertTrue(result.contains("Abe"));
        assertTrue(result.contains("Chris"));
        assertTrue(result.contains("Dan"));
        assertTrue(result.contains("Joe"));
        assertFalse(result.contains("Bob"));
        assertFalse(result.contains("Ken"));
    }

    @Test
    void testSalespersonOrderCount() {
        Map<String, Integer> result = SqlExercise.salespersonOrderCount();
        assertEquals(1, result.get("Abe"));
        assertEquals(2, result.get("Bob*"));
        assertEquals(0, result.get("Chris"));
        assertEquals(3, result.get("Dan*"));
        assertEquals(1, result.get("Ken"));
        assertEquals(0, result.get("Joe"));
    }

    @Test
    void testSalespersonsWithOrdersToJackson() {
    List<String> result = SqlExercise.salespersonsWithOrdersToJackson();
    System.out.println("Vendedores com pedidos para Jackson: " + result);
    // Abe (id=1) e Dan (id=7) têm pedidos para clientes de Jackson
    assertTrue(result.contains("Abe"));
    assertTrue(result.contains("Dan"));
    }

    @Test
    void testTotalSalesBySalesperson() {
        Map<String, Integer> result = SqlExercise.totalSalesBySalesperson();
        assertEquals(460, result.get("Abe"));
        assertEquals(2940, result.get("Bob"));
        assertEquals(0, result.get("Chris"));
        assertEquals(1470, result.get("Dan"));
        assertEquals(1800, result.get("Ken"));
        assertEquals(0, result.get("Joe"));
    }
}
