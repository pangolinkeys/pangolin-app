package com.pangolinkeys.pangolin.adapters;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.pangolinkeys.activities.MainActivity;
import com.pangolinkeys.activities.NearEarthObjectActivity;
import com.pangolinkeys.nasa.models.asteroids.NearEarthObject;
import com.pangolinkeys.nasa.models.response.NeoResponse;
import com.pangolinkeys.pangolin.R;

public class NearEarthObjectAdapter extends RecyclerView.Adapter<NearEarthObjectAdapter.NeoViewHolder> {

    protected NeoResponse response;
    protected MainActivity parent;

    /**
     * @param response
     * @param parent
     */
    public NearEarthObjectAdapter(NeoResponse response, MainActivity parent) {
        this.response = response;
        this.parent = parent;
    }

    @NonNull
    @Override
    public NeoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ConstraintLayout v = (ConstraintLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.neo_holder, parent, false);
        return new NeoViewHolder(v, this.parent);
    }

    @Override
    public void onBindViewHolder(@NonNull NeoViewHolder holder, int position) {
        NearEarthObject object = getItemAtPosition(position);
        holder.bindViewHolder(object);
    }

    @Override
    public int getItemCount() {
        return response.near_earth_objects.length;
    }

    protected NearEarthObject getItemAtPosition(int position) {
        return response.near_earth_objects[position];
    }

    public static class NeoViewHolder extends RecyclerView.ViewHolder {
        protected ConstraintLayout view;
        protected MainActivity parent;

        public NeoViewHolder(ConstraintLayout view, MainActivity parent) {
            super(view);
            this.view = view;
            this.parent = parent;
        }

        public void bindViewHolder(final NearEarthObject object) {
            ((TextView) view.findViewById(R.id.tv_name)).setText(object.name);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(parent, NearEarthObjectActivity.class);
                    intent.putExtra("asteroidId", object.neo_reference_id);
                    parent.startActivity(intent);
                }
            });
        }
    }
}
