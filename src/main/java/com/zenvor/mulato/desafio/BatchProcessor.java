package com.zenvor.mulato.desafio;

import java.util.List;

/**
 * Exemplo de diagnóstico e otimização de batch process em Java.
 * Simula etapas e pontos de análise para performance.
 */
public class BatchProcessor {
    private final DatabaseService databaseService;
    private final FtpService ftpService;

    public BatchProcessor(DatabaseService databaseService, FtpService ftpService) {
        this.databaseService = databaseService;
        this.ftpService = ftpService;
    }

    /**
     * Executa o batch processando dados do banco e transferindo arquivos via FTP.
     */
    public void runBatch() {
        long start = System.currentTimeMillis();
        List<String> data = databaseService.fetchData(); // Diagnóstico: medir tempo e analisar queries
        for (String item : data) {
            String file = databaseService.generateFile(item);
            ftpService.sendFile(file); // Diagnóstico: medir tempo de transferência
        }
        long end = System.currentTimeMillis();
        System.out.println("Batch concluído em " + (end - start) + " ms");
    }
}
