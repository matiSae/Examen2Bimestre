package qm_BusinessLogic.qm_Entities;

public abstract class qmExobotBL {
    protected Integer idExobot;
    protected Integer noAccion;
    protected boolean entrenado;

    protected qmBrazoDerecho brazoDerecho;
    protected qmBrazoIzquierdo brazoIzquierdo;

    public qmExobotBL() {
        brazoDerecho = new qmBrazoDerecho();
        brazoIzquierdo = new qmBrazoIzquierdo();
        noAccion = 0;
    }

    public Integer getNoAccion() {
        return noAccion;
    }

    public void incrementarAccion() {
        noAccion++;
    }

    public abstract void ejecutar();

}
