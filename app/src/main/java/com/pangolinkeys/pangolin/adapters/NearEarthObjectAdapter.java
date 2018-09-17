package com.pangolinkeys.pangolin.adapters;

import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.pangolinkeys.nasa.models.asteroids.NearEarthObject;
import com.pangolinkeys.nasa.models.response.NeoResponse;
import com.pangolinkeys.pangolin.R;

public class NearEarthObjectAdapter extends RecyclerView.Adapter<NearEarthObjectAdapter.NeoViewHolder> {

    protected NeoResponse response;

    public NearEarthObjectAdapter(NeoResponse response) {
        this.response = response;
    }

    @NonNull
    @Override
    public NeoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ConstraintLayout v = (ConstraintLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.neo_holder, parent, false);
        NeoViewHolder vh = new NeoViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull NeoViewHolder holder, int position) {
        NearEarthObject object = getItemAtPosition(position);
        ((TextView) holder.view.findViewById(R.id.tv_name)).setText(object.name);
    }

    @Override
    public int getItemCount() {
        return response.near_earth_objects.length;
    }

    protected NearEarthObject getItemAtPosition(int position) {
        return response.near_earth_objects[position];
    }

    public static class NeoViewHolder extends RecyclerView.ViewHolder {
        public ConstraintLayout view;

        public NeoViewHolder(ConstraintLayout view) {
            super(view);
            this.view = view;
        }
    }
}
