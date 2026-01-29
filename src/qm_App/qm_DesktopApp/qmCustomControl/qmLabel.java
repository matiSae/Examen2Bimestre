package qm_App.qm_DesktopApp.qmCustomControl;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

import qm_Infrastructure.qmAppStyle;


public class qmLabel extends JLabel{
    public qmLabel(){
        qmCustomizeComponent();
    }
    public qmLabel(String qmText){
        setText(qmText);
        qmCustomizeComponent();
    }
    private void qmCustomizeComponent(){
        qmSetCustomizeComponent(getText(), qmAppStyle.FONT, qmAppStyle.COLOR_FONT_LIGHT, qmAppStyle.ALIGNMENT_LEFT);
    }
    public void qmSetCustomizeComponent(String qmText, Font  qmFont, Color qmColor, int qmAlignment) {
        setText(qmText);
        setFont(qmFont);
        setOpaque(false);
        setBackground(null);
        setForeground(qmColor);
        setHorizontalAlignment(qmAlignment);
        //setIcon(new ImageIcon(iconPath));
}
}
