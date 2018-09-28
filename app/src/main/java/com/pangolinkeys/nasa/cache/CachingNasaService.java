package com.pangolinkeys.nasa.cache;

import com.pangolinkeys.nasa.contracts.NasaServiceContract;
import com.pangolinkeys.nasa.models.asteroids.NearEarthObject;
import com.pangolinkeys.nasa.models.response.NeoResponse;
import com.pangolinkeys.nasa.request.NasaService;
import com.pangolinkeys.requests.contracts.ResponseHandler;

import java.util.HashMap;
import java.util.Map;

public class CachingNasaService implements NasaServiceContract {

    protected NasaService requestService;

    protected NeoResponse nearEarthObjectsResponse;
    protected Map<String, NearEarthObject> nearEarthObjectMap = new HashMap<>();

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

    @Override
    public void getNearEarthObject(final String asteroidId, final ResponseHandler<NearEarthObject> handler) {
        if (nearEarthObjectMap.containsKey(asteroidId)) {
            handler.onComplete(nearEarthObjectMap.get(asteroidId));
        } else {
            requestService.getNearEarthObject(asteroidId, new ResponseHandler<NearEarthObject>() {
                @Override
                public void onComplete(NearEarthObject response) {
                    nearEarthObjectMap.put(asteroidId, response);
                    handler.onComplete(response);
                }
            });
        }
    }
}
