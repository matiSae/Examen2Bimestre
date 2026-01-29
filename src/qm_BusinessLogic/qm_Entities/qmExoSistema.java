package qm_BusinessLogic.qm_Entities;

import java.util.HashMap;
import java.util.Map;

import qm_DataAcces.qmDTOs.qmExobotDTO;
import qm_Infrastructure.qmTools.qmCMDColor;
import qm_Infrastructure.qmTools.qmDataFile;

/**
 * Sistema de gestión de ExoBots
 * Coordina la creación, entrenamiento y ejecución de acciones de ExoBots
 */
public class qmExoSistema {

    private Map<Integer, qmExoComando> exobots;
    private Map<String, qmTipoArmaBL> armas;
    private Map<String, qmSoldado> soldadosExpertos;
    private qmIABot iaBot;

    public qmExoSistema() {
        this.exobots = new HashMap<>();
        this.armas = new HashMap<>();
        this.soldadosExpertos = new HashMap<>();
        this.iaBot = new qmIABot();
        inicializarArmas();
        inicializarSoldados();
    }

    /**
     * Inicializa los tipos de armas disponibles
     */
    private void inicializarArmas() {
        armas.put("Laser", new qmExpertoLaser());
        armas.put("Bayoneta", new qmExpertoBayoneta());
    }

    /**
     * Inicializa los soldados expertos disponibles
     */
    private void inicializarSoldados() {
        soldadosExpertos.put("Laser", new qmSoldado("Experto_Laser", "Láser"));
        soldadosExpertos.put("Bayoneta", new qmSoldado("Experto_Bayoneta", "Bayoneta"));
    }

    /**
     * Crea un nuevo ExoBot a partir de un DTO
     */
    public void crearExoBot(qmExobotDTO dto) {
        qmExoComando exoComando = new qmExoComando(dto);
        exobots.put(dto.getIdExobot(), exoComando);
        qmDataFile.writeExoTracer("GOOD : ExoBot creado con ID: " + dto.getIdExobot());
    }

    /**
     * Req2: Entrena un ExoBot con un tipo de arma
     */
    public void entrenarExoBot(Integer idExobot, String nombreArma) {
        qmExoComando exoComando = exobots.get(idExobot);
        if (exoComando == null) {
            qmDataFile.writeExoTracer("ERROR: ExoBot no encontrado con ID: " + idExobot);
            return;
        }

        qmTipoArmaBL arma = armas.get(nombreArma);
        if (arma == null) {
            qmDataFile.writeExoTracer("ERROR: Arma no encontrada: " + nombreArma);
            return;
        }

        qmSoldado soldado = soldadosExpertos.get(nombreArma);
        if (soldado == null) {
            qmDataFile.writeExoTracer("ERROR: Soldado experto no encontrado para: " + nombreArma);
            return;
        }

        qmExoComandoServicio.entrenarArma(exoComando, arma, soldado);
    }

    /**
     * Req3: Ejecuta una acción de arma del ExoBot
     */
    public void ejecutarAccionArma(Integer idExobot) {
        qmExoComando exoComando = exobots.get(idExobot);
        if (exoComando == null) {
            qmDataFile.writeExoTracer("ERROR: ExoBot no encontrado con ID: " + idExobot);
            return;
        }

        qmExoComandoServicio.ejecutarAccionArma(exoComando);
    }

    /**
     * Obtiene un ExoBot por su ID
     */
    public qmExoComando obtenerExoBot(Integer idExobot) {
        return exobots.get(idExobot);
    }

    /**
     * Obtiene un arma por su nombre
     */
    public qmTipoArmaBL obtenerArma(String nombreArma) {
        return armas.get(nombreArma);
    }

    /**
     * Obtiene un soldado experto por su especialidad
     */
    public qmSoldado obtenerSoldado(String especialidad) {
        return soldadosExpertos.get(especialidad);
    }

    /**
     * Obtiene la IA Bot del sistema
     */
    public qmIABot getIABot() {
        return iaBot;
    }

    /**
     * Registra información en el log
     */
    public static void registrarLog(String mensaje) {
        qmDataFile.writeExoTracer(mensaje);
        System.out.println(qmCMDColor.CYAN + mensaje + qmCMDColor.RESET);
    }

    /**
     * Registra un error en el log
     */
    public static void registrarError(String mensaje) {
        qmDataFile.writeExoTracer("ERROR: " + mensaje);
        System.err.println(qmCMDColor.RED + "ERROR: " + mensaje + qmCMDColor.RESET);
    }
}
