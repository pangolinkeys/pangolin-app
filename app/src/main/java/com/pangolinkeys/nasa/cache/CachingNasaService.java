package com.pangolinkeys.nasa.cache;

import android.app.Application;
import com.pangolinkeys.nasa.contracts.NasaServiceContract;
import com.pangolinkeys.nasa.models.asteroids.NearEarthObject;
import com.pangolinkeys.nasa.models.response.NeoResponse;
import com.pangolinkeys.nasa.request.NasaService;
import com.pangolinkeys.requests.contracts.ResponseHandler;

public class CachingNasaService implements NasaServiceContract {

    protected NasaService requestService;

    protected NeoResponse nearEarthObjectsResponse;

    public CachingNasaService(NasaService requestService) {
        this.requestService = requestService;
    }

    @Override
    public void getNearEarthObjects(final ResponseHandler<NeoResponse> handler) {

        if (nearEarthObjectsResponse == null) {
            requestService.getNearEarthObjects(new ResponseHandler<NeoResponse>() {
                @Override
                public void onComplete(NeoResponse response) {
                    nearEarthObjectsResponse = response;
                    handler.onComplete(response);
                }
            });
        } else {
            handler.onComplete(nearEarthObjectsResponse);
        }

    }
}
