package qm_App.qm_DesktopApp.qmCustomControl;
import javax.swing.ImageIcon;

import qm_Infrastructure.qmAppStyle;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
public class qmLabelLink extends qmLabel implements MouseListener{
        qmLabelLink(String qmText){
        super(qmText);
        qmSetPersonalizacion();
    }

    qmLabelLink(String qmText, String qmIconPath){
        super(qmText);
        qmSetPersonalizacion();
        setIcon(new ImageIcon(qmIconPath));
    }
    
    void qmSetPersonalizacion(){
        addMouseListener(this);
        setOpaque(false);
        setForeground(qmAppStyle.COLOR_FONT);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        // code
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // code
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // code
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.setCursor(qmAppStyle.CURSOR_HAND);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.setCursor(qmAppStyle.CURSOR_DEFAULT);
    }
}
