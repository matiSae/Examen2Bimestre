package qm_BusinessLogic.qm_Entities;

import qm_BusinessLogic.qm_Interfaces.IqmIAExobot;
import qm_Infrastructure.qmTools.qmDataFile;
import qm_Infrastructure.qmTools.qmCMDColor;

/**
 * IABOT - Asistente de IA para entrenamiento de ExoBots
 * Implementa IqmIAExobot para garantizar la realización de AcciónArma
 */
public class qmIABot extends qmIAExobot implements IqmIAExobot {

    private qmSoldado soldadoExpertoActual;
    private qmTipoArmaBL armaActual;
    private String accionArma;

    public qmIABot() {
        super();
    }

    /**
     * Entrena el exobot con un soldado experto
     */
    public void entrenarConExpertoArma(qmSoldado soldadoExperto, qmTipoArmaBL arma) {
        try {
            this.soldadoExpertoActual = soldadoExperto;
            this.armaActual = arma;
            this.accionArma = "Disparo";

            String mensaje = "GOOD : " + soldadoExperto.getNombre() + " " + 
                           arma.getNombre() + " " + accionArma;
            
            qmDataFile.writeExoTracer(mensaje);
            System.out.println(qmCMDColor.CYAN + mensaje + qmCMDColor.RESET);
            
        } catch (Exception e) {
            String mensajeError = "ERROR: Error en entrenamiento de " + arma.getNombre();
            qmDataFile.writeExoTracer(mensajeError);
            System.err.println(qmCMDColor.RED + mensajeError + qmCMDColor.RESET);
        }
    }

    /**
     * Ejecuta la acción de arma del exobot
     */
    @Override
    public void qmAccionArma() {
        if (armaActual != null) {
            String municionInfo = qmDataFile.getMunicionByArma(armaActual.getNombre());
            String mensaje = "GOOD : " + armaActual.getNombre() + " " + 
                           accionArma + " " + municionInfo;
            
            qmDataFile.writeExoTracer(mensaje);
            System.out.println(qmCMDColor.CYAN + mensaje + qmCMDColor.RESET);
            
            armaActual.qmDisparar(armaActual.getMunicion());
        }
    }

    @Override
    public void decidir() {
        qmAccionArma();
    }

    public qmTipoArmaBL getArmaActual() {
        return armaActual;
    }

    public void setArmaActual(qmTipoArmaBL arma) {
        this.armaActual = arma;
    }

    public Boolean qmValidar(){
        return true;
    }
}
