package com.pangolinkeys.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import butterknife.ButterKnife;
import com.pangolinkeys.pangolin.application.Pangolin;

public abstract class AbstractActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        ((Pangolin) getApplication()).getPangolinComponent().inject(this);
        ButterKnife.bind(this);
    }

    /**
     * Get the content view for the activity.
     *
     * @return
     */
    abstract protected int getContentView();

}
