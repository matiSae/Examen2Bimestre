package qm_App.qm_ConsoleApp;

import qm_DataAcces.qmDAOs.qmUsuarioDAO;
import qm_DataAcces.qmDTOs.qmUsuarioDTO;
import qm_Infrastructure.qmAppException;
import qm_Infrastructure.qmTools.qmCMD;
import qm_Infrastructure.qmTools.qmCMDColor;
import qm_Infrastructure.qmTools.qmCMDInput;
import qm_Infrastructure.qmTools.qmDataFile;

/**
 * Req1: Autenticación en consola
 * Sistema de login con máximo 3 intentos
 */
public class qmAutenticacion {

    private static final int MAX_INTENTOS = 3;
    private static qmUsuarioDAO usuarioDAO;

    static {
        try {
            usuarioDAO = new qmUsuarioDAO();
        } catch (qmAppException e) {
            System.err.println(qmCMDColor.RED + "Error inicializando DAO de Usuario" + qmCMDColor.RESET);
        }
    }

    public static qmUsuarioDTO autenticar() {
        qmCMD.clear();
        System.out.println(qmCMDColor.CYAN + "╔════════════════════════════════════╗");
        System.out.println("║    SISTEMA DE AUTENTICACIÓN EXOBOT ║");
        System.out.println("║      (Usuario: patmic, Clave: 123) ║");
        System.out.println("╚════════════════════════════════════╝" + qmCMDColor.RESET);

        int intentos = 0;
        qmUsuarioDTO usuarioAutenticado = null;

        while (intentos < MAX_INTENTOS) {
            try {
                System.out.println("\n┌─ Intento " + (intentos + 1) + " de " + MAX_INTENTOS);
                
                String cedula = qmCMDInput.readString("├─ Ingrese su cédula: ");
                String contrasena = qmCMDInput.readString("└─ Ingrese su contraseña: ");

                // Validar contra el usuario por defecto
                if (validarCredenciales(cedula, contrasena)) {
                    usuarioAutenticado = obtenerUsuario(cedula);
                    if (usuarioAutenticado != null && usuarioAutenticado.estaActivo()) {
                        qmDataFile.writeExoTracer("GOOD : Acceso concedido a usuario: " + cedula);
                        System.out.println(qmCMDColor.GREEN + "\n✓ Acceso concedido. Bienvenido!" + qmCMDColor.RESET);
                        return usuarioAutenticado;
                    }
                }

                intentos++;
                qmDataFile.writeExoTracer("ERROR: Acceso denegado. Intento " + intentos + " fallido");
                System.out.println(qmCMDColor.RED + "✗ Credenciales inválidas. Intentos restantes: " + 
                                 (MAX_INTENTOS - intentos) + qmCMDColor.RESET);

            } catch (Exception e) {
                qmDataFile.writeExoTracer("ERROR: Excepción durante autenticación: " + e.getMessage());
                intentos++;
                System.out.println(qmCMDColor.RED + "✗ Error en la entrada. Intentos restantes: " + 
                                 (MAX_INTENTOS - intentos) + qmCMDColor.RESET);
            }
        }

        // Se agotaron los intentos
        qmDataFile.writeExoTracer("ERROR: Acceso denegado. Se agotaron los 3 intentos de autenticación");
        System.out.println(qmCMDColor.RED + "\n✗ Acceso denegado. Se agotaron los intentos permitidos." + qmCMDColor.RESET);
        System.exit(1);
        return null;
    }

    /**
     * Valida las credenciales contra la base de datos
     */
    private static boolean validarCredenciales(String cedula, String contrasena) {
        try {
            qmUsuarioDTO usuario = usuarioDAO.read(cedula);
            if (usuario != null) {
                return usuario.getCedula().equals(cedula) && usuario.getContrasena().equals(contrasena);
            }
        } catch (qmAppException e) {
            // Si no existe el usuario en BD, validar contra credenciales por defecto
            return cedula.equals("1728482140") && contrasena.equals("123");
        }
        return false;
    }

    /**
     * Obtiene el usuario de la base de datos
     */
    private static qmUsuarioDTO obtenerUsuario(String cedula) {
        try {
            return usuarioDAO.read(cedula);
        } catch (qmAppException e) {
            // Crear un usuario por defecto si no existe
            if (cedula.equals("1728482140")) {
                qmUsuarioDTO usuario = new qmUsuarioDTO("patmic", "123", cedula);
                usuario.setEstado("A");
                return usuario;
            }
        }
        return null;
    }
}
