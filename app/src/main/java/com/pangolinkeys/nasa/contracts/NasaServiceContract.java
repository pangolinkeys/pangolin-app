package com.pangolinkeys.nasa.contracts;

import com.pangolinkeys.nasa.models.response.NeoResponse;
import com.pangolinkeys.requests.contracts.ResponseHandler;

public interface NasaServiceContract {
    void getNearEarthObjects(final ResponseHandler<NeoResponse> handler);
}
