package com.pangolinkeys.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import butterknife.ButterKnife;
import com.pangolinkeys.pangolin.application.Pangolin;

public abstract class AbstractActivity extends Activity {
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
