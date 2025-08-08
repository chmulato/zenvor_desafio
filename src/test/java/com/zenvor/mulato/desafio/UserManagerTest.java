package com.zenvor.mulato.desafio;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserManagerTest {
    @Test
    void testAddAndFindUser() {
        UserManager um = new UserManager();
        assertTrue(um.addUser("Ana", "ana@email.com", "Rua 1", "1234"));
        assertFalse(um.addUser("Ana", "ana@email.com", "Rua 1", "1234")); // email duplicado
        assertNotNull(um.findUser("ana@email.com"));
    }

    @Test
    void testUpdateUser() {
        UserManager um = new UserManager();
        um.addUser("Carlos", "carlos@email.com", null, null);
        assertTrue(um.updateUser("carlos@email.com", "Carlos Silva", "Rua 2", "5678"));
        assertEquals("Carlos Silva", um.findUser("carlos@email.com").getName());
        assertEquals("Rua 2", um.findUser("carlos@email.com").getAddress());
        assertEquals("5678", um.findUser("carlos@email.com").getPhone());
        assertFalse(um.updateUser("naoexiste@email.com", "X", null, null));
    }

    @Test
    void testDeleteUser() {
        UserManager um = new UserManager();
        um.addUser("João", "joao@email.com", null, null);
        assertFalse(um.deleteUser("joao@email.com", "user")); // não admin
        assertTrue(um.deleteUser("joao@email.com", "admin"));
        assertNull(um.findUser("joao@email.com"));
    }

    @Test
    void testRequiredFields() {
        UserManager um = new UserManager();
        assertFalse(um.addUser("", "", null, null));
        assertFalse(um.addUser(null, null, null, null));
        assertFalse(um.addUser("Maria", "", null, null));
        assertFalse(um.addUser("", "maria@email.com", null, null));
    }
}
