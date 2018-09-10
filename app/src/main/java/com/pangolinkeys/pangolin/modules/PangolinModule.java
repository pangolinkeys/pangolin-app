package com.pangolinkeys.pangolin.modules;

import android.app.Application;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.pangolinkeys.nasa.NasaService;
import com.pangolinkeys.pangolin.application.Pangolin;
import dagger.Module;
import dagger.Provides;

import javax.inject.Inject;
import javax.inject.Singleton;

@Module
public class PangolinModule {

    protected Application application;

    public PangolinModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public Application providesApplication() {
        return this.application;
    }

    @Provides
    @Singleton
    public NasaService getNasaService(Application application) {
        return new NasaService(application);
    }

    @Provides
    @Singleton
    @Inject
    public RequestQueue getRequestQueue(Application application) {
        return Volley.newRequestQueue(application);
    }

    @Provides
    @Singleton
    public Gson getGson() {
        return new Gson();
    }
}
