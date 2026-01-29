package qm_BusinessLogic.qm_Entities;

import qm_BusinessLogic.qmFactoryBL;
import qm_BusinessLogic.qm_Interfaces.IqmArma;
import qm_DataAcces.qmDAOs.qmTipoArmaDAO;
import qm_DataAcces.qmDTOs.qmTipoArmaDTO;
import qm_Infrastructure.qmTools.qmDataFile;

public abstract class qmTipoArmaBL implements IqmArma {

    protected String nombre;
    protected Integer municion;

    public String getNombre() {
        return nombre;
    }

    public Integer getMunicion() {
        return municion;
    }

    protected void consumirMunicion() {
        if (municion != null && municion > 0)
            municion--;
    }

    @Override
    public void qmDisparar(Integer municionUsada) {
        usar();
    }

    public abstract void usar();
}
