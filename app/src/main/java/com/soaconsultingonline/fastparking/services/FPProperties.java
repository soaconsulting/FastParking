package com.soaconsultingonline.fastparking.services;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Jimmy on 10/09/2016.
 */
public class FPProperties {

    // Instancia el singular
    private static FPProperties ourInstance;
    private static Context context;
    private static Properties props;

    /**
     * Obtiene la instancia del singular.
     *
     * @return
     */
    public static FPProperties getInstance(Context c) {
        if (ourInstance == null)
            ourInstance = new FPProperties();
        context = c;
        return ourInstance;
    }

    /**
     * Constructor Privado.
     */
    private FPProperties() {
        // Lee el archivo de propiedades
        props = new Properties();
        AssetManager assets = context.getAssets();
        try {
            InputStream inputStream = assets.open("fastparking.properties");
            props.load(inputStream);
        } catch (IOException e) {
            Log.e("FPProperties", e.getMessage(), e);
        }
    }

    /**
     * Obtiene el valor de una propiedad por nombre.
     *
     * @param p
     * @return
     */
    public String getProperty(String p) {
        return props.getProperty(p);
    }

}
