package com.zenvor.mulato.desafio;

import java.util.*;

/**
 * Gerenciador de plantas para o sistema XYZ – Fase 1.
 * Permite criar, atualizar, deletar e buscar plantas, com validações de negócio.
 */
public class PlantManager {
    private final Map<Integer, Plant> plants = new HashMap<>();
    private final Set<String> adminUsers = new HashSet<>(Collections.singleton("admin"));

    public boolean createPlant(int code, String description) {
        if (plants.containsKey(code)) return false;
        if (description != null && description.length() > 10) return false;
        plants.put(code, new Plant(code, description));
        return true;
    }

    public boolean updatePlant(int code, String description) {
        Plant plant = plants.get(code);
        if (plant == null) return false;
        if (description != null && description.length() > 10) return false;
        plant.setDescription(description);
        return true;
    }

    public boolean deletePlant(int code, String user) {
        if (!adminUsers.contains(user)) return false;
        return plants.remove(code) != null;
    }

    public Plant findPlant(int code) {
        return plants.get(code);
    }

    public boolean isCodeUnique(int code) {
        return !plants.containsKey(code);
    }

    // Simples entidade de planta
    public static class Plant {
        private final int code;
        private String description;
        public Plant(int code, String description) {
            this.code = code;
            this.description = description;
        }
        public int getCode() { return code; }
        public String getDescription() { return description; }
        public void setDescription(String description) { this.description = description; }
    }
}
