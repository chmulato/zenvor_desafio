package com.zenvor.mulato.desafio;

/**
 * Exemplo de uso do padrão Strategy para desacoplar o envio de e-mails.
 */
public class NotificationManager {
    private final EmailService emailService;

    public NotificationManager(EmailService emailService) {
        this.emailService = emailService;
    }

    public void notifyUser(String to, String subject, String message) {
        emailService.sendEmail(to, subject, message);
    }
}
