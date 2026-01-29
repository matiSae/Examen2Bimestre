package qm_Infrastructure;

import javax.swing.JOptionPane;

public abstract class qmAppMSG {
    private qmAppMSG() {}
    public static final void showMsg(String msg){
        JOptionPane.showMessageDialog(null, msg, "🐜 EXOBOT", JOptionPane.INFORMATION_MESSAGE);
    }
    public static final void showMsgError(String msg){
        JOptionPane.showMessageDialog(null, msg, "💀 EXOBOT", JOptionPane.OK_OPTION);
    }
    public static final boolean showConfirmYesNo(String msg){
        return (JOptionPane.showConfirmDialog(null, msg, "🐜 EXOBOT", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);
    }
}