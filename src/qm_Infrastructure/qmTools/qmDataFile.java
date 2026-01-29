package qm_Infrastructure.qmTools;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import qm_Infrastructure.qmAppConfig;

public class qmDataFile {
    private qmDataFile() {}

    /**
     * Escribe en el archivo ExoTracer.txt
     */
    public static void writeExoTracer(String mensaje) {
        try {
            String filePath = qmAppConfig.getEXOMUN();
            filePath = filePath.replace("ExoMunision.txt", "ExoTracer.txt");
            
            try (FileWriter fw = new FileWriter(filePath, true);
                 PrintWriter writer = new PrintWriter(fw)) {
                writer.println(mensaje);
                System.out.println(qmCMDColor.GREEN + "[ExoTracer] " + mensaje + qmCMDColor.RESET);
            }
        } catch (IOException e) {
            System.err.println(qmCMDColor.RED + "[Error escribiendo ExoTracer] " + e.getMessage() + qmCMDColor.RESET);
        }
    }

    /**
     * Lee el archivo ExoMunision.txt y retorna un Map con las municiones
     */
    public static Map<String, String> readExoMunicion() {
        Map<String, String> municiones = new HashMap<>();
        try {
            String filePath = qmAppConfig.getEXOMUN();
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            
            // Parsear el archivo (formato: TipoArma -> Municiones)
            for (String line : lines) {
                if (!line.trim().isEmpty()) {
                    String[] partes = line.split(",");
                    if (partes.length >= 2) {
                        String arma = partes[0].trim();
                        String municion = partes[1].trim();
                        municiones.put(arma, municion);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println(qmCMDColor.RED + "[Error leyendo ExoMunision] " + e.getMessage() + qmCMDColor.RESET);
        }
        return municiones;
    }

    /**
     * Obtiene la munición para un arma específica
     */
    public static String getMunicionByArma(String nombreArma) {
        Map<String, String> municiones = readExoMunicion();
        return municiones.getOrDefault(nombreArma, "Desconocida");
    }
}
