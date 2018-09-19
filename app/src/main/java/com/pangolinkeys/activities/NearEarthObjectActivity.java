package com.pangolinkeys.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import com.pangolinkeys.pangolin.R;
import com.pangolinkeys.pangolin.application.Pangolin;

public class NearEarthObjectActivity extends AbstractActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((Pangolin) getApplication()).getPangolinComponent().inject(this);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_neo;
    }
}
