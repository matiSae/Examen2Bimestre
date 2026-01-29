package qm_Infrastructure;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import qm_Infrastructure.qmTools.qmCMDColor;

public class qmAppException extends Exception{
    private static final DateTimeFormatter qmFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
 
    public qmAppException(String qmShowMsg) {
        super((qmShowMsg == null || qmShowMsg.isBlank())? qmAppConfig.MSG_DEFAULT_ERROR : qmShowMsg);
        saveLogFile(null, null, null);
    }
    public qmAppException(String qmShowMsg, Exception e, Class<?> qmClase, String qmMetodo) {
        super((qmShowMsg == null || qmShowMsg.isBlank())? qmAppConfig.MSG_DEFAULT_ERROR : qmShowMsg);
        saveLogFile(e.getMessage(), qmClase, qmMetodo);
    }

    private void saveLogFile(String qmLogMsg, Class<?> qmClase, String qmMetodo) {
        String qmTimeStamp  = LocalDateTime.now().format(qmFORMATTER);
        String qmClassName  = (qmClase == null) ? qmAppConfig.MSG_DEFAULT_CLASS : qmClase.getSimpleName();
        String qmMethodName = (qmMetodo == null || qmMetodo.isBlank()) ? qmAppConfig.MSG_DEFAULT_METHOD : qmMetodo;
        qmLogMsg = (qmLogMsg == null || qmLogMsg.isBlank())? qmAppConfig.MSG_DEFAULT_ERROR : qmLogMsg;
        qmLogMsg = String.format("┌─🤖❌─ SHOW ❱❱ %s \n└── LOG » %s | %s.%s | %s", getMessage(), qmTimeStamp, qmClassName, qmMethodName,qmLogMsg);

        try (PrintWriter writer = new PrintWriter(new FileWriter(qmAppConfig.getLOGFILE(), true))) {
            System.err.println(qmCMDColor.BLUE  + qmLogMsg);
            writer.println(qmLogMsg);
        } catch (Exception e) {
            System.err.println(qmCMDColor.RED  + "[AppException.saveLogFile] ❱ " + e.getMessage());
        }finally {
            System.out.println(qmCMDColor.RESET);
        }
    }


}
