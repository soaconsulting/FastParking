package com.soaconsultingonline.fastparking.services;

/**
 * Created by Jimmy on 11/09/2016.
 */
public interface ClientIF {
    /**
     * Retorna la respuesta a la actividad que invoca el servicio
     *
     * @param result
     */
    public void onResponseReceived(Object result);
}
