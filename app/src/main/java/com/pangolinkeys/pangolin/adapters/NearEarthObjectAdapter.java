package com.pangolinkeys.pangolin.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import com.pangolinkeys.nasa.models.asteroids.NearEarthObject;
import com.pangolinkeys.nasa.models.response.NeoResponse;

public class NearEarthObjectAdapter extends RecyclerView.Adapter<NearEarthObjectAdapter.NeoViewHolder> {

    protected NeoResponse response;

    public NearEarthObjectAdapter(NeoResponse response) {
        this.response = response;
    }

    @NonNull
    @Override
    public NeoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull NeoViewHolder holder, int position) {
        NearEarthObject object = getItemAtPosition(position);
    }

    @Override
    public int getItemCount() {
        return response.near_earth_objects.length;
    }

    protected NearEarthObject getItemAtPosition(int position) {
        return response.near_earth_objects[position];
    }

    public static class NeoViewHolder extends RecyclerView.ViewHolder {
        public View view;

        public NeoViewHolder(View view) {
            super(view);
            this.view = view;
        }
    }
}
