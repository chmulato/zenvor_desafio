package com.zenvor.mulato.desafio;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Simulação de consultas SQL em Java usando dados das tabelas do exercício.
 */
public class SqlExercise {
    // Dados simulados
    public static final List<Salesperson> SALESPERSONS = List.of(
        new Salesperson(1, "Abe", 61, 140000),
        new Salesperson(2, "Bob", 34, 44000),
        new Salesperson(5, "Chris", 34, 40000),
        new Salesperson(7, "Dan", 41, 52000),
        new Salesperson(8, "Ken", 57, 115000),
        new Salesperson(11, "Joe", 38, 38000)
    );
    public static final List<Customer> CUSTOMERS = List.of(
        new Customer(4, "Samsonic", "Pleasant", "J"),
        new Customer(6, "Panasung", "Oaktown", "J"),
        new Customer(7, "Samony", "Jackson", "B"),
        new Customer(9, "Orange", "Jackson", "B")
    );
    public static final List<Order> ORDERS = List.of(
        new Order(10, "8/2/96", 4, 2, 540),
        new Order(20, "1/30/99", 4, 8, 1800),
        new Order(30, "7/14/95", 9, 1, 460),
        new Order(40, "1/29/98", 7, 2, 2400),
        new Order(50, "2/3/98", 6, 7, 600),
        new Order(60, "3/2/98", 6, 7, 720),
        new Order(70, "5/6/98", 9, 7, 150)
    );

    // a) Salesperson sem pedidos com Samsonic
    public static List<String> salespersonsWithoutSamsonic() {
        Set<Integer> samsonicOrders = ORDERS.stream()
            .filter(o -> CUSTOMERS.stream().anyMatch(c -> c.id == o.customerId && c.name.equals("Samsonic")))
            .map(o -> o.salespersonId)
            .collect(Collectors.toSet());
        return SALESPERSONS.stream()
            .filter(s -> !samsonicOrders.contains(s.id))
            .map(s -> s.name)
            .collect(Collectors.toList());
    }

    // b) Salesperson com 2+ pedidos (adiciona *)
    public static Map<String, Integer> salespersonOrderCount() {
        Map<Integer, Long> count = ORDERS.stream().collect(Collectors.groupingBy(o -> o.salespersonId, Collectors.counting()));
        Map<String, Integer> result = new LinkedHashMap<>();
        for (Salesperson s : SALESPERSONS) {
            long c = count.getOrDefault(s.id, 0L);
            String name = c >= 2 ? s.name + "*" : s.name;
            result.put(name, (int)c);
        }
        return result;
    }

    // c) Salesperson que fizeram pedidos para Jackson
    public static List<String> salespersonsWithOrdersToJackson() {
        Set<Integer> jacksonCustomerIds = CUSTOMERS.stream().filter(c -> c.city.equals("Jackson")).map(c -> c.id).collect(Collectors.toSet());
        Set<Integer> salesIds = ORDERS.stream().filter(o -> jacksonCustomerIds.contains(o.customerId)).map(o -> o.salespersonId).collect(Collectors.toSet());
        return SALESPERSONS.stream().filter(s -> salesIds.contains(s.id)).map(s -> s.name).collect(Collectors.toList());
    }

    // d) Total de vendas por Salesperson
    public static Map<String, Integer> totalSalesBySalesperson() {
        Map<Integer, Integer> sales = new HashMap<>();
        for (Order o : ORDERS) {
            sales.put(o.salespersonId, sales.getOrDefault(o.salespersonId, 0) + o.amount);
        }
        Map<String, Integer> result = new LinkedHashMap<>();
        for (Salesperson s : SALESPERSONS) {
            result.put(s.name, sales.getOrDefault(s.id, 0));
        }
        return result;
    }

    // Classes de dados
    public static class Salesperson {
        public final int id, age, salary;
        public final String name;
        public Salesperson(int id, String name, int age, int salary) {
            this.id = id; this.name = name; this.age = age; this.salary = salary;
        }
    }
    public static class Customer {
        public final int id; public final String name, city, industryType;
        public Customer(int id, String name, String city, String industryType) {
            this.id = id; this.name = name; this.city = city; this.industryType = industryType;
        }
    }
    public static class Order {
        public final int id, customerId, salespersonId, amount;
        public final String orderDate;
        public Order(int id, String orderDate, int customerId, int salespersonId, int amount) {
            this.id = id; this.orderDate = orderDate; this.customerId = customerId; this.salespersonId = salespersonId; this.amount = amount;
        }
    }
}
