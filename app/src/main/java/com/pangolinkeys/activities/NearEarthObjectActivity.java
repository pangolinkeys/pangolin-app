package com.pangolinkeys.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.TextView;
import butterknife.BindView;
import com.pangolinkeys.nasa.contracts.NasaServiceContract;
import com.pangolinkeys.nasa.models.asteroids.NearEarthObject;
import com.pangolinkeys.pangolin.R;
import com.pangolinkeys.pangolin.application.Pangolin;
import com.pangolinkeys.requests.contracts.ResponseHandler;

import javax.inject.Inject;

public class NearEarthObjectActivity extends AbstractActivity {

    protected NearEarthObject nearEarthObject;

    @BindView(R.id.tv_neo_name)
    TextView neoName;

    @Inject
    NasaServiceContract nasaService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((Pangolin) getApplication()).getPangolinComponent().inject(this);
        nasaService.getNearEarthObject(getIntent().getStringExtra("asteroidId"), new ResponseHandler<NearEarthObject>() {
            @Override
            public void onComplete(NearEarthObject response) {
                NearEarthObjectActivity.this.nearEarthObject = response;
                bindUI();
            }
        });
    }

    /**
     * Sets up the user interface
     */
    protected void bindUI() {
        setTitle(nearEarthObject.name);
        neoName.setText(nearEarthObject.name);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_neo;
    }
}
