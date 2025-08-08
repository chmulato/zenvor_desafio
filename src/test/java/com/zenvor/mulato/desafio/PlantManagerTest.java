package com.zenvor.mulato.desafio;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlantManagerTest {
    @Test
    void testCreateAndFindPlant() {
        PlantManager pm = new PlantManager();
        assertTrue(pm.createPlant(1, "Rosa"));
        assertFalse(pm.createPlant(1, "Lírio")); // código duplicado
        assertEquals("Rosa", pm.findPlant(1).getDescription());
    }

    @Test
    void testUpdatePlant() {
        PlantManager pm = new PlantManager();
        pm.createPlant(2, "Orquídea");
        assertTrue(pm.updatePlant(2, "Tulipa"));
        assertEquals("Tulipa", pm.findPlant(2).getDescription());
        assertFalse(pm.updatePlant(3, "Cacto")); // planta inexistente
    }

    @Test
    void testDeletePlant() {
        PlantManager pm = new PlantManager();
        pm.createPlant(3, "Cacto");
        assertFalse(pm.deletePlant(3, "user")); // não admin
        assertTrue(pm.deletePlant(3, "admin"));
        assertNull(pm.findPlant(3));
    }

    @Test
    void testDescriptionLength() {
        PlantManager pm = new PlantManager();
        assertFalse(pm.createPlant(4, "MuitoLongoNome")); // >10 chars
        assertTrue(pm.createPlant(5, "Curto"));
        assertFalse(pm.updatePlant(5, "NomeMuitoLongo"));
    }
}
