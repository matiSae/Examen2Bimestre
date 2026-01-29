package qm_Infrastructure.qmTools;

import java.util.Scanner;

public class qmCMDInput {
    static Scanner sc = new Scanner(System.in);
    private qmCMDInput(){}

    
    /**
     * Captura un numero entero y que sea mayor a cero
     * @param qmEtiqueta
     * @return numero entero positivo
     */
    public static int getNumeroPositivo(String qmEtiqueta, String qmErrorMsg){
        int n =-1;
        String qmStr;
        do{
            System.out.print(qmEtiqueta);
            qmStr =  sc.next();
            try {
                n = Integer.parseInt(qmStr);
            } catch (Exception _) {
                System.out.println(qmErrorMsg);
            }
        }while(n<0);
        return n;
    }
    
    public static String getCaracteres(String qmEtiqueta)
    {
        String qmStr="";
        do {
            System.out.print(qmEtiqueta);
            qmStr =  sc.next().trim();
            if (qmStr.trim().equals(""))
                System.out.println(" :( Valor no valido... !");
        } while (qmStr.isEmpty());
        return qmStr;
    }

    public static String readString(String qmEtiqueta) {
        System.out.print(qmEtiqueta);
        return sc.nextLine().trim();
    }
}

