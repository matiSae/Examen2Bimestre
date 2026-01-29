package qm_App.qm_DesktopApp.qmForm;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import qm_App.qm_DesktopApp.qmCustomControl.qmButton;
import qm_App.qm_DesktopApp.qmCustomControl.qmLabel;
import qm_App.qm_DesktopApp.qmCustomControl.qmTextBox;
import qm_BusinessLogic.qmFactoryBL;
import qm_DataAcces.qmDAOs.qmExobotDAO;
import qm_DataAcces.qmDTOs.qmExobotDTO;
import qm_Infrastructure.qmAppMSG;
import qm_Infrastructure.qmAppStyle;
import qm_Infrastructure.qmTools.qmCMD;

public class qmPEXoTrop extends JPanel implements ActionListener {
    private transient qmFactoryBL<qmExobotDTO> blFactory = new qmFactoryBL<>(qmExobotDAO.class);
    private transient qmExobotDTO dtoExobot = new qmExobotDTO();
    private Integer regAct  = 0;
    private Integer regMax  = 0;
    public qmPEXoTrop(){
        try {
            initComponents();
                    
            btnRowIni.addActionListener(this);
            btnRowAnt.addActionListener(this);
            btnRowSig.addActionListener(this);
            btnRowFin.addActionListener(this);

            btnNuevo.addActionListener(     e -> btnNuevoClick      ());
            btnGuardar.addActionListener(   e -> btnGuardarClick    ());
            btnEliminar.addActionListener(  e -> btnEliminarClick   ());
            btnCancelar.addActionListener(  e -> btnCancelarClick   ());

            loadRowData();
            showRowData();
            showDataTable();
        }   catch (Exception e) {
            qmAppMSG.showMsg("Error al cargar los datos tipo de persona: " + e.getMessage());
        }
    }
    
    private void loadRowData() throws Exception {
        regAct   = blFactory.getMinReg("idExobot");
        regMax   = blFactory.getMaxReg("idExobot");
        dtoExobot  = blFactory.getBy(regAct);
    }
    private void showRowData() {
        boolean isDTONull = (dtoExobot == null || dtoExobot.getIdExobot() == null);
        txtIdExobot.setText   ((isDTONull) ? " " : dtoExobot.getIdExobot().toString());
        txtNombre.setText   ((isDTONull) ? " " : dtoExobot.getIdTipoExobot().toString());
        txtNombre.setText   ((isDTONull) ? " ": dtoExobot.getEntreno());
        txtNombre.setText   ((isDTONull) ? " ": dtoExobot.getNoAccion().toString());
        lblTotalReg.setText (regAct.toString() + " de " + regMax);
    }
    private void showDataTable() throws Exception {
        String[] header = {"IdPT", "Tipo", "Estado"};
        Object[][] data = new Object[regMax][3];
        int index = 0;
        for (qmExobotDTO  d : blFactory.getAll()) {
            data[index][0] = d.getIdExobot();
            data[index][1] = d.getIdTipoExobot();
            data[index][2] = d.getEntreno();
            data[index][3] = d.getNoAccion();
            index++;
        }

        JTable table = new JTable(data, header);
        table.setShowHorizontalLines(true);
        table.setRowSelectionAllowed(true);
        table.setGridColor(Color.lightGray);
        table.setColumnSelectionAllowed(false);
        table.setFillsViewportHeight(true);

        pnlTabla.removeAll();
        pnlTabla.setLayout(new BorderLayout()); 
        pnlTabla.add(new JScrollPane(table), BorderLayout.CENTER);

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.rowAtPoint(e.getPoint());
                int col = table.columnAtPoint(e.getPoint());
                if (row >= 0 && col >= 0) {
                    String strID = table.getModel().getValueAt(row, 0).toString();
                    regAct = Integer.parseInt(strID);
                    try {
                        dtoExobot = blFactory.getBy(regAct);
                        showRowData();
                    } catch (Exception _) { 
                        System.out.println("");
                    }
                    System.out.println("Tabla.Selected: " + strID);
                }
            }
        });
    }

    private void btnNuevoClick() {
        dtoExobot = null;
        showRowData();
    }
    private void btnGuardarClick() {
        boolean isDTONull = (dtoExobot == null );
        try {
            if (qmAppMSG.showConfirmYesNo("¿Seguro que desea " + ((isDTONull) ? "AGREGAR ?" : "ACTUALIZAR ?"))) {
                if (isDTONull)  
                    dtoExobot = new qmExobotDTO();
                else
                    dtoExobot.setIdTipoExobot(regAct);

                if( !((isDTONull)   ? blFactory.add(dtoExobot) 
                                    : blFactory.upd(dtoExobot))) 
                    throw new Exception("Error al almacenar el registo...");
                
                loadRowData();
                showRowData();
                showDataTable();
            }
        } catch (Exception e) {
            qmAppMSG.showMsgError( e.getMessage());
        }
    }
    private void btnEliminarClick() {
        try {
            if (qmAppMSG.showConfirmYesNo("Seguro que desea Eliminar?")) {

                if (!blFactory.del(dtoExobot.getIdExobot()))
                    throw new Exception("Error al eliminar...!");
    
                loadRowData();
                showRowData();
                showDataTable();
            }
        } catch (Exception e) {
            qmAppMSG.showMsgError(e.getMessage());
        }
    }
    private void btnCancelarClick() {
        try {
            if(dtoExobot == null)
                loadRowData();
            showRowData();
        } catch (Exception ex) { qmCMD.printlnError(ex.toString());}
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnRowIni)
            regAct = 1;
        if (e.getSource() == btnRowAnt && (regAct > 1))
            regAct--;
        if (e.getSource() == btnRowSig && (regAct < regMax))
            regAct++;
        if (e.getSource() == btnRowFin)
            regAct = regMax;
        try {
            dtoExobot  = blFactory.getBy(regAct);
            showRowData(); 
        } catch (Exception ex) { qmCMD.printlnError(ex.toString());}
    }
  

    /************************
    * FormDesing : qm_mic
    ************************/
    int tbAncho = 550, tbAlto = 150;  // tabla de datos
    private qmLabel 
            lblTitulo   = new qmLabel("TIPO DE Exobot"),
            lblIdExobot   = new qmLabel(" Código Exobot :"),
            lblNombre   = new qmLabel("*Tipo de Exobot:"),
            lblTotalReg = new qmLabel(" 0 de 0 ");
    private qmTextBox 
            txtIdExobot   = new qmTextBox(),
            txtNombre   = new qmTextBox();
    private qmButton 
            btnPageIni  = new qmButton(" |< "),
            btnPageAnt  = new qmButton(" << "),
            btnPageSig  = new qmButton(" >> "),
            btnPageFin  = new qmButton(" >| "),

            btnRowIni   = new qmButton(" |< "),
            btnRowAnt   = new qmButton(" << "),
            btnRowSig   = new qmButton(" >> "),
            btnRowFin   = new qmButton(" >| "),

            btnNuevo    = new qmButton("Nuevo"),
            btnGuardar  = new qmButton("Guardar"),
            btnCancelar = new qmButton("Cancelar"),
            btnEliminar = new qmButton("Eliminar");
    private JPanel 
            pnlTabla    = new JPanel(),
            pnlBtnRow   = new JPanel(new FlowLayout()),
            pnlBtnPage  = new JPanel(new FlowLayout()),
            pnlBtnCRUD  = new JPanel(new FlowLayout());
    
    private void initComponents() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        txtIdExobot.setEnabled(false);

        pnlBtnPage.add(btnPageIni);
        pnlBtnPage.add(btnPageAnt);
        pnlBtnPage.add(new qmLabel(" Page:( "));
        //pnlBtnPage.add(lblTotalReg); //cambiar
        pnlBtnPage.add(new qmLabel(" ) "));
        pnlBtnPage.add(btnPageSig);
        pnlBtnPage.add(btnPageFin);

        pnlBtnRow.add(btnRowIni);
        pnlBtnRow.add(btnRowAnt);
        pnlBtnRow.add(lblTotalReg);
        pnlBtnRow.add(btnRowSig);
        pnlBtnRow.add(btnRowFin);

        pnlBtnCRUD.add(btnNuevo);
        pnlBtnCRUD.add(btnGuardar);
        pnlBtnCRUD.add(btnCancelar);
        pnlBtnCRUD.add(btnEliminar);
        pnlBtnCRUD.setBorder(qmAppStyle.createBorderRect());

        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        add(lblTitulo, gbc);

        gbc.gridy = 1;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        add(new JLabel("■ Sección de datos: "), gbc);
        gbc.gridy = 1;
        gbc.gridx = 1;
        add(pnlBtnPage, gbc);

        gbc.gridy = 2;
        gbc.gridx = 0;
        gbc.gridwidth = 3;
        gbc.ipady = tbAlto;
        gbc.ipadx = tbAncho;
        pnlTabla.add(new JLabel("Loading data..."));
        add(pnlTabla, gbc);

        gbc.ipady = 1;
        gbc.ipadx = 1;

        gbc.gridy = 3;
        gbc.gridx = 0;
        gbc.gridwidth = 3;
        gbc.insets = new Insets(50, 0, 0, 0);  // Ajusta el valor superior a 50
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(Box.createRigidArea(new Dimension(0, 0)), gbc);

        gbc.insets = new Insets(10, 0, 0, 0);  

        gbc.gridy = 4;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        add(new JLabel("■ Sección de registro: "), gbc);
        gbc.gridy = 4;
        gbc.gridx = 1;
        add(pnlBtnRow, gbc);

        gbc.gridy = 5;
        gbc.gridx = 0;
        add(lblIdExobot, gbc);
        gbc.gridy = 5;
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER; // Indica que este componente ocupa toda la fila
        add(txtIdExobot, gbc);

        gbc.gridy = 6;
        gbc.gridx = 0;
        add(lblNombre, gbc);
        gbc.gridy = 6;
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER; // Indica que este componente ocupa toda la fila
        add(txtNombre, gbc);

        // gbc.gridy = 7;
        // gbc.gridx = 1;
        // gbc.gridwidth = 2;
        // gbc.fill = GridBagConstraints.HORIZONTAL;
        // add(pnlBtnRow, gbc);

        gbc.gridy = 7;
        gbc.gridx = 0;
        gbc.gridwidth = 3;
        gbc.insets = new Insets(30, 0, 0, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(pnlBtnCRUD, gbc);
    }
}
