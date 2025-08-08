package com.zenvor.mulato.desafio;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {
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
    void testRegisterUser() {
        UserRepository repo = new UserRepository();
        FakeEmailService email = new FakeEmailService();
        UserService service = new UserService(repo, email);
        service.registerUser("Maria", "maria@email.com");
        assertEquals(1, repo.findAll().size());
        assertEquals("Maria", repo.findAll().get(0).getName());
        assertEquals("maria@email.com", email.lastTo);
        assertEquals("Bem-vindo", email.lastSubject);
        assertTrue(email.lastBody.contains("Maria"));
    }
}
