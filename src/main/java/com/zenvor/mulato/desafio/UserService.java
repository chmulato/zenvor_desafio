package com.zenvor.mulato.desafio;

/**
 * Exemplo de integração de serviço externo (simulando um serviço REST) usando Java.
 * Demonstra injeção de dependência e comunicação entre componentes.
 */
public class UserService {
    private final UserRepository userRepository;
    private final EmailService emailService;

    public UserService(UserRepository userRepository, EmailService emailService) {
        this.userRepository = userRepository;
        this.emailService = emailService;
    }

    public void registerUser(String name, String email) {
        userRepository.save(new User(name, email));
        emailService.sendEmail(email, "Bem-vindo", "Olá, " + name + "! Cadastro realizado.");
    }
}
