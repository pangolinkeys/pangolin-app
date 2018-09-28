package com.pangolinkeys.nasa.models.asteroids;

public class NearEarthObject {
    public String
            neo_reference_id,
            nasa_jpl_url,
            name;
    public double absolute_magnitude_h;
    public boolean is_potentially_hazardous_asteroid, is_sentry_object;
    public EstimatedDiameter estimated_diameter;
    public CloseApproachData[] close_approach_data;
}