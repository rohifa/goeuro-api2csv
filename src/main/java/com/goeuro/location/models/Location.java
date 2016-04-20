package com.goeuro.location.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created by rohi on 4/17/16.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public @Data class Location {

    public static @Data class GeoPosition {

        private double latitude;

        private double longitude;
    }

    @JsonProperty("_id")
    private int id;

    private String name;

    private String type;

    @JsonProperty("geo_position")
    private GeoPosition geoPosition;

}
