package com.pangolinkeys.activities;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import butterknife.BindView;
import com.pangolinkeys.nasa.contracts.NasaServiceContract;
import com.pangolinkeys.nasa.request.NasaService;
import com.pangolinkeys.nasa.models.response.NeoResponse;
import com.pangolinkeys.pangolin.R;
import com.pangolinkeys.pangolin.adapters.NearEarthObjectAdapter;
import com.pangolinkeys.pangolin.application.Pangolin;
import com.pangolinkeys.requests.contracts.ResponseHandler;

import javax.inject.Inject;

public class MainActivity extends AbstractActivity {

    protected NeoResponse nearEarthObjects = null;

    @Inject
    NasaServiceContract nasaService;

    @BindView(R.id.neo_recycler)
    RecyclerView neoRecycler;

    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((Pangolin) getApplication()).getPangolinComponent().inject(this);
        setUpAdapters();

        setTitle(getString(R.string.main_activity_title));

        nasaService.getNearEarthObjects(new ResponseHandler<NeoResponse>() {
            @Override
            public void onComplete(NeoResponse nearEarthObjects) {
                MainActivity.this.nearEarthObjects = nearEarthObjects;
                requestsComplete();
            }
        });
    }

    protected void requestsComplete() {
        bindAdapters();
    }

    /**
     * Creates correct instances of adapters.
     */
    protected void setUpAdapters() {
        layoutManager = new LinearLayoutManager(this);
        neoRecycler.setLayoutManager(layoutManager);
    }

    /**
     * Binds the data to the adapter.
     */
    protected void bindAdapters() {
        neoRecycler.invalidate();
        adapter = new NearEarthObjectAdapter(nearEarthObjects, this);
        neoRecycler.setAdapter(adapter);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }
}
