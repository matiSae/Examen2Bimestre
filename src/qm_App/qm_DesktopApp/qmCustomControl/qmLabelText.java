package qm_App.qm_DesktopApp.qmCustomControl;
import javax.swing.*;

import qm_Infrastructure.qmAppStyle;

import java.awt.*;

public class qmLabelText extends JPanel{
    private qmLabel    qmLblEtiqueta = new qmLabel();
    private qmTextBox  qmTxtContenido= new qmTextBox();

    public qmLabelText(String etiqueta) {
        setLayout(new BorderLayout());

        qmLblEtiqueta.qmSetCustomizeComponent(  etiqueta, 
                                            qmAppStyle.FONT_SMALL, 
                                            qmAppStyle.COLOR_FONT_LIGHT, 
                                            qmAppStyle.ALIGNMENT_LEFT); 
        add(qmLblEtiqueta, BorderLayout.NORTH);
        add(qmTxtContenido, BorderLayout.CENTER);
    }
}
