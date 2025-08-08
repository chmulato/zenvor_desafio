package com.zenvor.mulato.desafio;

import org.junit.jupiter.api.Test;

class BatchProcessorTest {
    @Test
    void testRunBatch() {
        DatabaseService db = new DatabaseService();
        FtpService ftp = new FtpService();
        BatchProcessor batch = new BatchProcessor(db, ftp);
        batch.runBatch();
        // Verifique a saída manualmente ou use mocks para validação real
    }
}
