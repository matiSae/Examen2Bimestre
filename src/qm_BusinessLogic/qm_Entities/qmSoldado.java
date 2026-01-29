package qm_BusinessLogic.qm_Entities;

/**
 * Soldado Experto para entrenar ExoBots en uso de armas
 */
public class qmSoldado {
    private String nombre;
    private String especialidad;
    private qmExobotBL exobot;

    public qmSoldado(String nombre, String especialidad) {
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    public qmSoldado(String nombre, String especialidad, qmExobotBL exobot) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.exobot = exobot;
    }

    public void ordenarAccion() {
        if (exobot != null) {
            exobot.ejecutar();
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public qmExobotBL getExobot() {
        return exobot;
    }

    public void setExobot(qmExobotBL exobot) {
        this.exobot = exobot;
    }
}
