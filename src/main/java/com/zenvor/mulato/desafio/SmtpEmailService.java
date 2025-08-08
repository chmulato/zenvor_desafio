package com.zenvor.mulato.desafio;

/**
 * Implementação fictícia usando uma biblioteca de terceiros (exemplo).
 */
public class SmtpEmailService implements EmailService {
    @Override
    public void sendEmail(String to, String subject, String body) {
        // Aqui seria feita a chamada à biblioteca real de envio de e-mails
        System.out.printf("Enviando e-mail para %s: %s - %s\n", to, subject, body);
    }
}
