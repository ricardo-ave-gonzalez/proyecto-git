package com.deverlop.java.utiles;

public class Utiles {
    public static void ver(Object ...params) {
        for (Object o : params) {
            System.out.println(o);
        }
    }
    public static void dormir(int ds) {
        try { Thread.sleep(ds*100); } catch (Exception ex) {}
    }
    public static int[] crearArray(int cantidad) {
        int[] intArray = new int[cantidad];
        for (int x=0; x < cantidad;x++) {
            intArray[x] = x;
        }
        return intArray;
    }
    public static void tryCatch(Runnable porcionCodigo) {
        try {
            ver("Voy a realizar una consulta");
            porcionCodigo.run();
            ver("Fin realizacion consulta exitosa");
        }
        catch (Exception ex) {
            ver("Se produjo un error: ", ex.getMessage());
            throw new RuntimeException();
        }
    }
    public static void intentar(Runnable porcionCodigo, String mensaje) {
        try {
            porcionCodigo.run();
        }
        catch (Exception ex) {
            throw new RuntimeException(mensaje);
        }
    }
}
