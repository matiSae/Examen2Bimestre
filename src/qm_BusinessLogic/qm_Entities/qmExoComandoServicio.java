package qm_BusinessLogic.qm_Entities;

import qm_DataAcces.qmDTOs.qmExobotDTO;
import qm_Infrastructure.qmTools.qmDataFile;
import qm_Infrastructure.qmTools.qmCMDColor;

/**
 * Servicio para manejar acciones de ExoBot
 * Req3: Ejecutar acciones de arma con lectura de munición/energía
 */
public class qmExoComandoServicio {

    /**
     * Entrena el exobot con un arma específica y soldado experto
     */
    public static void entrenarArma(qmExoComando exoComando, qmTipoArmaBL arma, qmSoldado soldadoExperto) {
        try {
            if (exoComando == null || arma == null || soldadoExperto == null) {
                String error = "ERROR: Parámetros inválidos para entrenamiento";
                qmDataFile.writeExoTracer(error);
                System.err.println(qmCMDColor.RED + error + qmCMDColor.RESET);
                return;
            }

            // Entrenar el exobot
            exoComando.setArmaActual(arma);
            exoComando.setEntrenado(true);

            // Registrar entrenamiento
            String mensaje = "GOOD : " + soldadoExperto.getNombre() + " " + 
                           arma.getNombre() + " Disparo";
            
            qmDataFile.writeExoTracer(mensaje);
            System.out.println(qmCMDColor.CYAN + mensaje + qmCMDColor.RESET);

        } catch (Exception e) {
            String errorMsg = "ERROR: Excepción en entrenarArma: " + e.getMessage();
            qmDataFile.writeExoTracer(errorMsg);
            System.err.println(qmCMDColor.RED + errorMsg + qmCMDColor.RESET);
        }
    }

    /**
     * Req3: Ejecuta la acción de arma
     * Lee el archivo ExoMunision.txt y registra la acción
     */
    public static void ejecutarAccionArma(qmExoComando exoComando) {
        try {
            if (exoComando == null || !exoComando.estaEntrenado()) {
                String error = "ERROR: ExoComando no está entrenado";
                qmDataFile.writeExoTracer(error);
                System.err.println(qmCMDColor.RED + error + qmCMDColor.RESET);
                return;
            }

            qmTipoArmaBL arma = exoComando.getArmaActual();
            if (arma == null) {
                String error = "ERROR: No hay arma asignada";
                qmDataFile.writeExoTracer(error);
                System.err.println(qmCMDColor.RED + error + qmCMDColor.RESET);
                return;
            }

            // Leer munición/energía del archivo
            String municionInfo = qmDataFile.getMunicionByArma(arma.getNombre());
            
            // Incrementar contador de acciones
            exoComando.incrementarAccion();

            // Registrar la acción
            String mensaje = "GOOD : " + arma.getNombre() + " Disparo " + municionInfo;
            qmDataFile.writeExoTracer(mensaje);
            System.out.println(qmCMDColor.CYAN + mensaje + qmCMDColor.RESET);

            // Ejecutar el arma
            exoComando.ejecutar();

        } catch (Exception e) {
            String errorMsg = "ERROR: Excepción en ejecutarAccionArma: " + e.getMessage();
            qmDataFile.writeExoTracer(errorMsg);
            System.err.println(qmCMDColor.RED + errorMsg + qmCMDColor.RESET);
        }
    }
}
