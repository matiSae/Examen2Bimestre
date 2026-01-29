package qm_BusinessLogic.qm_Entities;

import qm_BusinessLogic.qm_Interfaces.IqmEntrenarLaser;
import qm_Infrastructure.qmTools.qmDataFile;

public class qmExpertoLaser extends qmTipoArmaBL {

    public qmExpertoLaser() {
        this.nombre = "Laser";
        this.municion = 100;
    }

    @Override
    public void usar() {
        consumirMunicion();
        String municionInfo = qmDataFile.getMunicionByArma("Laser");
        qmDataFile.writeExoTracer("GOOD : Laser disparado | Energía: " + municion + " | Tipo: " + municionInfo);
    }

    @Override
    public void qmDisparar(Integer municion) {
        usar();
    }
}
