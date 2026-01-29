package qm_BusinessLogic.qm_Entities;

/**
 * IAEXO - Sistema de Inteligencia Artificial derivado de una matriz
 * Base para la IA de los ExoBots
 */
public abstract class qmIAExobot {
    
    protected qmExobotBL exobot;
    protected boolean entrenado;

    public qmIAExobot() {
    }

    /**
     * Decide la acción del ExoBot
     */
    public abstract void decidir();

    public qmExobotBL getExobot() {
        return exobot;
    }

    public void setExobot(qmExobotBL exobot) {
        this.exobot = exobot;
    }

    public boolean isEntrenado() {
        return entrenado;
    }

    public void setEntrenado(boolean entrenado) {
        this.entrenado = entrenado;
    }
}
