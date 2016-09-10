package com.soaconsultingonline.fastparking.services;

/**
 * Created by Jimmy on 10/09/2016.
 */
public class FPServicesBroker {

    // Instancia el singular
    private static FPServicesBroker ourInstance = new FPServicesBroker();

    /**
     * Obtiene la instancia del singular.
     *
     * @return
     */
    public static FPServicesBroker getInstance() {
        return ourInstance;
    }

    /**
     * Constructor Privado.
     */
    private FPServicesBroker() {
    }


}
