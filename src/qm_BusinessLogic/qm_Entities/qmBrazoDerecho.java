package qm_BusinessLogic.qm_Entities;

import qm_BusinessLogic.qm_Interfaces.IqmArma;

public class qmBrazoDerecho {
    private IqmArma arma;
    public void setArma(IqmArma arma){
        this.arma=arma;
    }

    public void usar(Integer municion){
        arma.qmDisparar(municion);
    }
}
