package qm_Infrastructure.qmTools;

public class qmCMD {
    private qmCMD() {}

    public static void clear () {
        System.out.print("\033[H\033[2J");
        System. out.flush();
    }

    public static void println(String msg) {
        if(System.console() != null)
            System.out.println(qmCMDColor.CYAN + msg + qmCMDColor.RESET);
    }

    public static void printlnError (String msg) {
        if(System.console() != null)
            System.out.println(qmCMDColor.RED + msg + qmCMDColor.RESET);
    }
}   

