package qm_BusinessLogic.qm_Entities;

import qm_Infrastructure.qmTools.qmDataFile;

public class qmExpertoBayoneta extends qmTipoArmaBL {
    
    public qmExpertoBayoneta() {
        this.nombre = "Bayoneta";
        this.municion = null;  // La bayoneta no consume munición
    }

    @Override
    public void usar() {
        String municionInfo = qmDataFile.getMunicionByArma("Bayoneta");
        qmDataFile.writeExoTracer("GOOD : Bayoneta utilizada | Tipo: " + municionInfo);
    }

    @Override
    public void qmDisparar(Integer municion) {
        usar();
    }
}
