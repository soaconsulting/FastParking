package com.soaconsultingonline.fastparking.services;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;

import com.soaconsultingonline.fastparking.activity.MapsActivity;
import com.soaconsultingonline.fastparking.database.vo.ParqueaderoVO;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Jimmy on 10/09/2016.
 */
public abstract class ConsultaParqueaderosService extends AsyncTask<String, Void, List<ParqueaderoVO>> implements ClientIF {

    private ProgressDialog dialog;

    /**
     * Constructor
     *
     * @param activity
     */
    public ConsultaParqueaderosService(MapsActivity activity) {
        dialog = new ProgressDialog(activity);
    }

    @Override
    protected void onPreExecute() {
        dialog.setMessage("Cargando Marcadores ...");
        dialog.show();
    }

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
    protected List<ParqueaderoVO> doInBackground(String... params) {
        try {
            final String url = params[0];
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            ParqueaderoVO[] res = restTemplate.getForObject(url, ParqueaderoVO[].class);
            return Arrays.asList(res);
        } catch (Exception e) {
            Log.e("ConsultaParqService", e.getMessage(), e);
        }
        return null;
    }

    /**
     *
     * @param res
     */
    @Override
    protected void onPostExecute(List<ParqueaderoVO> res) {
        if (dialog.isShowing()) {
            dialog.dismiss();
        }
        onResponseReceived(res);
    }

    public abstract void onResponseReceived(Object result);
}
