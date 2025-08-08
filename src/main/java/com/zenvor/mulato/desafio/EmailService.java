package com.zenvor.mulato.desafio;

/**
 * Interface para serviço de envio de e-mails.
 * Permite desacoplar a implementação concreta (ex: biblioteca de terceiros).
 */
public interface EmailService {
    void sendEmail(String to, String subject, String body);
}
