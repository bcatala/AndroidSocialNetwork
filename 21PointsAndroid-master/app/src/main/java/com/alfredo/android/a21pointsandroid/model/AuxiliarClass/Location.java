package com.alfredo.android.a21pointsandroid.model.AuxiliarClass;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Location {

        @SerializedName("address")
        @Expose
        private String address;
        @SerializedName("city")
        @Expose
        private String city;
        @SerializedName("country")
        @Expose
        private String country;
        @SerializedName("county")
        @Expose
        private String county;
        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("latitude")
        @Expose
        private double latitude;
        @SerializedName("longitude")
        @Expose
        private double longitude;
        @SerializedName("postalCode")
        @Expose
        private String postalCode;
        @SerializedName("stateProvice")
        @Expose
        private String stateProvice;
        @SerializedName("urlGoogleMaps")
        @Expose
        private String urlGoogleMaps;
        @SerializedName("urlOpenStreetMap")
        @Expose
        private String urlOpenStreetMap;
}
