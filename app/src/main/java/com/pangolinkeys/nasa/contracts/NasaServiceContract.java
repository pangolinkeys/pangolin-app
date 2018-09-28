package com.pangolinkeys.nasa.contracts;

import com.pangolinkeys.nasa.models.asteroids.NearEarthObject;
import com.pangolinkeys.nasa.models.response.NeoResponse;
import com.pangolinkeys.requests.contracts.ResponseHandler;

public interface NasaServiceContract {
    /**
     * Get Near Earth Objects from the browse API
     *
     * @param handler
     */
    void getNearEarthObjects(final ResponseHandler<NeoResponse> handler);

    /**
     * Get a specific asteroid.
     *
     * @param asteroidId
     * @param handler
     */
    void getNearEarthObject(String asteroidId, ResponseHandler<NearEarthObject> handler);
}