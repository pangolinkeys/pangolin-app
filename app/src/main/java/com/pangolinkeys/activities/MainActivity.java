package com.pangolinkeys.activities;

import android.os.Bundle;
import android.widget.TextView;
import butterknife.BindView;
import com.pangolinkeys.nasa.contracts.NasaServiceContract;
import com.pangolinkeys.nasa.request.NasaService;
import com.pangolinkeys.nasa.models.response.NeoResponse;
import com.pangolinkeys.pangolin.R;
import com.pangolinkeys.pangolin.application.Pangolin;
import com.pangolinkeys.requests.contracts.ResponseHandler;

import javax.inject.Inject;

public class MainActivity extends AbstractActivity {

    protected NeoResponse nearEarthObjects = null;

    @Inject
    NasaServiceContract nasaService;

    @BindView(R.id.test_text_view)
    TextView test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((Pangolin) getApplicationContext()).getPangolinComponent().inject(this);
        nasaService.getNearEarthObjects(new ResponseHandler<NeoResponse>() {
            @Override
            public void onComplete(NeoResponse nearEarthObjects) {
                MainActivity.this.nearEarthObjects = nearEarthObjects;
                requestsComplete();
            }
        });
    }

    protected void requestsComplete() {
        this.test.setText(String.valueOf(this.nearEarthObjects.near_earth_objects.length));
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }
}
