package qm_App.qm_DesktopApp.qmCustomControl;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;

import qm_Infrastructure.qmAppStyle;

import javax.swing.ImageIcon;


public class qmButton extends JButton implements MouseListener {
    public qmButton(String qmText){
        qmCustomizeComponent(qmText);
    }
    public qmButton(String qmText, String qmIconPath){
        qmCustomizeComponent(qmText, qmIconPath);
    }

    public void qmCustomizeComponent(String qmText, String qmIconPath){ 
        setSize(20, 70);
        addMouseListener(this);
        qmCustomizeComponent(qmText);
        setBounds(50, 30, 90, 20); 
        setIcon(new ImageIcon(qmIconPath));
        setFont(qmAppStyle.FONT);
    }
    public void qmCustomizeComponent(String qmText) {
        setText(qmText);
        setOpaque(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setForeground(qmAppStyle.COLOR_FONT);
        setHorizontalAlignment(qmAppStyle.ALIGNMENT_LEFT);
        setFont(qmAppStyle.FONT);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // Este evento no se utiliza en este componente.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Este evento no se utiliza en este componente.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // Este evento no se utiliza en este componente.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        setForeground(Color.BLACK);
        setCursor(qmAppStyle.CURSOR_HAND);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        setForeground(Color.GRAY);
        setCursor(qmAppStyle.CURSOR_DEFAULT);
    }
}
