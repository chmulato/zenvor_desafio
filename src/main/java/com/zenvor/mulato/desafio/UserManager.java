package com.zenvor.mulato.desafio;

import java.util.*;

/**
 * Gerenciador de usuários para cadastro, atualização, deleção e busca.
 * Regras: nome e email obrigatórios, email único, apenas admin pode deletar outros usuários.
 */
public class UserManager {
    private final Map<String, User> users = new HashMap<>(); // email como chave
    private final Set<String> adminUsers = new HashSet<>(Collections.singleton("admin"));

    public boolean addUser(String name, String email, String address, String phone) {
        if (name == null || name.isBlank() || email == null || email.isBlank()) return false;
        if (users.containsKey(email)) return false;
        users.put(email, new User(name, email, address, phone));
        return true;
    }

    public boolean updateUser(String email, String name, String address, String phone) {
        User user = users.get(email);
        if (user == null) return false;
        if (name != null && !name.isBlank()) user.setName(name);
        if (address != null) user.setAddress(address);
        if (phone != null) user.setPhone(phone);
        return true;
    }

    public boolean deleteUser(String email, String requester) {
        if (!adminUsers.contains(requester)) return false;
        return users.remove(email) != null;
    }

    public User findUser(String email) {
        return users.get(email);
    }

    public static class User {
        private String name, email, address, phone;
        public User(String name, String email, String address, String phone) {
            this.name = name; this.email = email; this.address = address; this.phone = phone;
        }
        public String getName() { return name; }
        public String getEmail() { return email; }
        public String getAddress() { return address; }
        public String getPhone() { return phone; }
        public void setName(String name) { this.name = name; }
        public void setAddress(String address) { this.address = address; }
        public void setPhone(String phone) { this.phone = phone; }
    }
}
