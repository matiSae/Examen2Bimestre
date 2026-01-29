package qm_App.qm_DesktopApp.qmForm;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import qm_App.qm_DesktopApp.qmCustomControl.qmButton;



public class AppStart extends JFrame {
    AppMenu   pnlMenu = new AppMenu();
    JPanel    pnlMain = new PHome();

    public AppStart(String tilteApp) {
        initComponents(tilteApp);
 
        qmButton btnHome   = new qmButton("🤖 Home");
        qmButton btnExoTroper   = new qmButton("🤖 ExoTroper");

        btnHome   .addActionListener(e -> setPanel(new PHome()));

        pnlMenu.addMenuItem(btnHome   );
        pnlMenu.addMenuItem(btnExoTroper   );    

    }

    private void setPanel(JPanel formularioPanel) {
        Container container = getContentPane();
        container.remove(pnlMain);
        pnlMain = formularioPanel;
        container.add(pnlMain, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    private void initComponents(String tilteApp) {
        setTitle(tilteApp);
        setSize(930, 600);
        setResizable(false);
        setLocationRelativeTo(null); // Centrar en la pantalla
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Crear un contenedor para los dos paneles usando BorderLayout
        Container container = getContentPane();
        container.setLayout(new BorderLayout());

        // Agregar los paneles al contenedor
        container.add(pnlMenu, BorderLayout.WEST);
        container.add(pnlMain, BorderLayout.CENTER);
        setVisible(true);
    }
}