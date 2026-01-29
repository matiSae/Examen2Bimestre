package qm_App.qm_ConsoleApp;

import qm_App.qm_DesktopApp.qmForm.AppStart;
import qm_BusinessLogic.qm_Entities.*;
import qm_DataAcces.qmDTOs.qmExobotDTO;
import qm_DataAcces.qmDTOs.qmUsuarioDTO;
import qm_Infrastructure.qmTools.qmCMD;
import qm_Infrastructure.qmTools.qmCMDColor;
import qm_Infrastructure.qmTools.qmDataFile;

/**
 */
public class qmAppExoTroper {

    public static void main(String[] args) {
        try {
            // Req1: Autenticación en consola
            qmCMD.clear();
            System.out.println(qmCMDColor.BOLD_CYAN + 
                "╔════════════════════════════════════════════════════╗\n" +
                "║              🤖 SISTEMA EXOBOT 🤖                 ║\n" +
                "║      Sistema de Entrenamiento de Exotroopers       ║\n" +
                "╚════════════════════════════════════════════════════╝" + 
                qmCMDColor.RESET);

            qmUsuarioDTO usuario = qmAutenticacion.autenticar();

            if (usuario != null) {
                System.out.println(qmCMDColor.GREEN + 
                    "\n✓ Autenticación exitosa. Usuario: " + usuario.getUsuario() + 
                    qmCMDColor.RESET);

                // Demostración del sistema de ExoBots
                demostrarSistema();

                System.out.println(qmCMDColor.GREEN + 
                    "\n✓ Sistema listo. Continuando con la GUI..." + qmCMDColor.RESET);
                
                // Aquí se iniciaría la interfaz gráfica
                new AppStart("Exotroper");
                // AppStart.main(args);
            }

        } catch (Exception e) {
            System.err.println(qmCMDColor.RED + "Error fatal en la aplicación: " + e.getMessage() + qmCMDColor.RESET);
            e.printStackTrace();
            qmDataFile.writeExoTracer("ERROR: " + e.getMessage());
            System.exit(1);
        }
    }

    /**
     */
    private static void demostrarSistema() {
        System.out.println(qmCMDColor.CYAN + 
            "\n┌─ Demostrando Req2: Entrenamiento de ExoBots\n" +
            "└─ Demostrando Req3: Acciones de Arma" + qmCMDColor.RESET);

        // Crear el sistema de ExoBots
        qmExoSistema sistema = new qmExoSistema();

        try {
            // Crear un ExoBot
            qmExobotDTO dtoExo = new qmExobotDTO(1, 1, "NO", 0);
            sistema.crearExoBot(dtoExo);

            // Req2: Entrenar el ExoBot con Laser
            System.out.println(qmCMDColor.YELLOW + 
                "\n[Entrenando ExoBot con Laser...]" + qmCMDColor.RESET);
            sistema.entrenarExoBot(1, "Laser");

            // Req3: Ejecutar acciones de arma
            System.out.println(qmCMDColor.YELLOW + 
                "\n[Ejecutando Acción de Arma 1...]" + qmCMDColor.RESET);
            sistema.ejecutarAccionArma(1);

            System.out.println(qmCMDColor.YELLOW + 
                "\n[Ejecutando Acción de Arma 2...]" + qmCMDColor.RESET);
            sistema.ejecutarAccionArma(1);

            // Entrenar con Bayoneta
            System.out.println(qmCMDColor.YELLOW + 
                "\n[Entrenando ExoBot con Bayoneta...]" + qmCMDColor.RESET);
            sistema.entrenarExoBot(1, "Bayoneta");

            System.out.println(qmCMDColor.YELLOW + 
                "\n[Ejecutando Acción de Bayoneta...]" + qmCMDColor.RESET);
            sistema.ejecutarAccionArma(1);

            System.out.println(qmCMDColor.GREEN + 
                "\n✓ Demostración completada exitosamente" + qmCMDColor.RESET);

        } catch (Exception e) {
            System.err.println(qmCMDColor.RED + 
                "Error en la demostración: " + e.getMessage() + qmCMDColor.RESET);
            qmDataFile.writeExoTracer("ERROR: Error en la demostración del sistema");
        }
    }
}


