package com.zenvor.mulato.desafio;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NotificationManagerTest {
    static class FakeEmailService implements EmailService {
        String lastTo, lastSubject, lastBody;
        @Override
        public void sendEmail(String to, String subject, String body) {
            this.lastTo = to;
            this.lastSubject = subject;
            this.lastBody = body;
        }
    }

    @Test
    void testNotifyUser() {
        FakeEmailService fake = new FakeEmailService();
        NotificationManager manager = new NotificationManager(fake);
        manager.notifyUser("user@example.com", "Assunto", "Mensagem");
        assertEquals("user@example.com", fake.lastTo);
        assertEquals("Assunto", fake.lastSubject);
        assertEquals("Mensagem", fake.lastBody);
    }
}
