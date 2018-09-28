package com.pangolinkeys.pangolin.components;

import com.pangolinkeys.activities.AbstractActivity;
import com.pangolinkeys.activities.MainActivity;
import com.pangolinkeys.activities.NearEarthObjectActivity;
import com.pangolinkeys.nasa.request.NasaService;
import com.pangolinkeys.pangolin.modules.PangolinModule;
import com.pangolinkeys.services.AbstractRequestService;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = PangolinModule.class)
public interface PangolinComponent {

    /**
     * @param activity
     */
    void inject(AbstractActivity activity);

    /**
     * @param activity
     */
    void inject(MainActivity activity);

    /**
     * @param activity
     */
    void inject(NearEarthObjectActivity activity);

    /**
     * @param service
     */
    void inject(AbstractRequestService service);

    /**
     * @param service
     */
    void inject(NasaService service);
}
