package com.pangolinkeys.activities;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import butterknife.BindView;
import com.pangolinkeys.nasa.NasaService;
import com.pangolinkeys.nasa.models.response.NeoResponse;
import com.pangolinkeys.pangolin.R;
import com.pangolinkeys.pangolin.application.Pangolin;
import com.pangolinkeys.requests.contracts.ResponseHandler;

import javax.inject.Inject;

public class MainActivity extends AbstractActivity {

    @Inject
    NasaService nasaService;

    @BindView(R.id.test_text_view)
    TextView test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        nasaService.getNearEarthObjects(new ResponseHandler<NeoResponse>() {
            @Override
            public void onComplete(NeoResponse response) {
                test.setText(response.near_earth_objects[0].name);
            }
        });
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }
}
