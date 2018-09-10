package com.pangolinkeys.services;

import android.app.Application;
import com.android.volley.RequestQueue;
import com.google.gson.Gson;
import com.pangolinkeys.pangolin.application.Pangolin;

import javax.inject.Inject;

public abstract class AbstractService {

    protected Application application;

    @Inject
    protected RequestQueue requestQueue;

    @Inject
    protected Gson gson;

    public AbstractService(Application application) {
        this.application = application;
        ((Pangolin) application).getPangolinComponent().inject(this);
    }
}
