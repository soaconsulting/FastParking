package com.soaconsultingonline.fastparking.services;

import android.os.AsyncTask;

import com.soaconsultingonline.fastparking.database.vo.UsuarioVO;

/**
 * Created by Jimmy on 10/09/2016.
 */
public class UsuarioService extends AsyncTask<Void, Void, UsuarioVO>{

    /**
     * Override this method to perform a computation on a background thread. The
     * specified parameters are the parameters passed to {@link #execute}
     * by the caller of this task.
     * <p/>
     * This method can call {@link #publishProgress} to publish updates
     * on the UI thread.
     *
     * @param params The parameters of the task.
     * @return A result, defined by the subclass of this task.
     * @see #onPreExecute()
     * @see #onPostExecute
     * @see #publishProgress
     */
    @Override
    protected UsuarioVO doInBackground(Void... params) {
        return null;
    }
}
