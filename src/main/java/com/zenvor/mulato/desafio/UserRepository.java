package com.zenvor.mulato.desafio;

import java.util.ArrayList;
import java.util.List;

/**
 * Simulação de repositório de usuários (poderia ser um DAO ou interface para banco de dados).
 */
public class UserRepository {
    private final List<User> users = new ArrayList<>();

    public void save(User user) {
        users.add(user);
    }

    public List<User> findAll() {
        return new ArrayList<>(users);
    }
}
