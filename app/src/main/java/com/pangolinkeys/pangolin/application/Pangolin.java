package com.pangolinkeys.pangolin.application;

import android.app.Application;
import com.pangolinkeys.pangolin.components.DaggerPangolinComponent;
import com.pangolinkeys.pangolin.components.PangolinComponent;
import com.pangolinkeys.pangolin.modules.PangolinModule;

public class Pangolin extends Application {

    private PangolinComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = createPangolinComponent();
    }

    public PangolinComponent getPangolinComponent() {
        return component;
    }

    private PangolinComponent createPangolinComponent() {
        return DaggerPangolinComponent.builder()
                .pangolinModule(new PangolinModule(this))
                .build();
    }
}
