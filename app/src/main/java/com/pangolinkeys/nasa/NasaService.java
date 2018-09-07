package com.pangolinkeys.nasa;

import android.app.Application;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.pangolinkeys.nasa.models.response.NeoResponse;
import com.pangolinkeys.pangolin.R;
import com.pangolinkeys.pangolin.application.Pangolin;
import com.pangolinkeys.requests.contracts.ResponseHandler;
import com.pangolinkeys.services.AbstractService;
import org.json.JSONObject;

import javax.inject.Inject;

public class NasaService extends AbstractService {

    @Inject
    protected RequestQueue requestQueue;

    @Inject
    protected Gson gson;

    protected Application application;
    protected String apiRoot, apiKey;

    public NasaService(Application application) {
        super(application);
        apiRoot = application.getResources().getString(R.string.api_root);
        apiKey = application.getResources().getString(R.string.nasa_api_key);
    }

    /**
     * @param handler
     */
    public void getNearEarthObjects(final ResponseHandler<NeoResponse> handler) {
        requestQueue.add(new JsonObjectRequest(apiRoot + "neo/rest/v1/neo/browse?api_key=" + apiKey, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                handler.onComplete(gson.fromJson(response.toString(), NeoResponse.class));
            }
        }, null));
    }

}
