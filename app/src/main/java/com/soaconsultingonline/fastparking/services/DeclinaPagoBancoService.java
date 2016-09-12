package com.soaconsultingonline.fastparking.services;

import android.os.AsyncTask;
import android.util.Log;

import com.soaconsultingonline.fastparking.database.vo.FPBusinessResponseVO;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Jimmy on 10/09/2016.
 */
public class DeclinaPagoBancoService extends AsyncTask<String, Void, FPBusinessResponseVO>{

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
    protected FPBusinessResponseVO doInBackground(String... params) {
        try {
            final String url = params[0];
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            FPBusinessResponseVO res = restTemplate.getForObject(url, FPBusinessResponseVO.class);
            return res;
        } catch (Exception e) {
            Log.e("DeclinaPagoBancoService", e.getMessage(), e);
        }
        return null;
    }

    /**
     *
     * @param res
     */
    @Override
    protected void onPostExecute(FPBusinessResponseVO res) {
    }
}
