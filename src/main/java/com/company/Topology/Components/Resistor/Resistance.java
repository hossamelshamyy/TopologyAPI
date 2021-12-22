package com.company.Topology.Components.Resistor;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Resistance {
    @JsonProperty("default")
    private double Default;

    @JsonProperty("min")
    private double min;

    @JsonProperty("max")
    private double max;

    @JsonCreator
    public Resistance(@JsonProperty("default") double aDefault, @JsonProperty("min") double min, @JsonProperty("max") double max) {
        Default = aDefault;
        this.min = min;
        this.max = max;
    }

    public double getDefault() {
        return Default;
    }

    public void setDefault(double aDefault) {
        Default = aDefault;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    @Override
    public String toString() {
        return ", Resistance = { " + "Default = " + Default + ", Min = " + min + ", Max = " + max + " } ";
    }

    @Override
    public boolean equals(Object obj) {
        Resistance r = (Resistance) obj;
        return Default == r.Default && min == r.min && max == r.max;
    }
}
