package qm_BusinessLogic.qm_Entities;

import qm_DataAcces.qmDTOs.qmExobotDTO;
import qm_Infrastructure.qmTools.qmDataFile;

public class qmExoComando extends qmExobotBL {
    
    private qmTipoArmaBL armaActual;

    public qmExoComando(qmExobotDTO dto) {
        super();
        this.idExobot = dto.getIdExobot();
        this.noAccion = dto.getNoAccion();
        this.entrenado = dto.getEntreno().equalsIgnoreCase("SI");
    }

    public qmExoComando(qmExobotDTO dto, qmTipoArmaBL arma) {
        this(dto);
        this.armaActual = arma;
    }

    @Override
    public void ejecutar() {
        incrementarAccion();

        if (entrenado && armaActual != null) {
            // Usar brazo derecho por defecto
            if (brazoDerecho != null) {
                brazoDerecho.setArma(armaActual);
                brazoDerecho.usar(armaActual.getMunicion());
            }
        } else {
            qmDataFile.writeExoTracer("ERROR : ExoComando no está entrenado o no tiene arma asignada");
        }
    }

    public void setArmaActual(qmTipoArmaBL arma) {
        this.armaActual = arma;
    }

    public qmTipoArmaBL getArmaActual() {
        return armaActual;
    }

    public boolean estaEntrenado() {
        return entrenado;
    }

    public void setEntrenado(boolean entrenado) {
        this.entrenado = entrenado;
    }
}
