package com.company.Topology;

import com.company.Topology.Components.Prototypes.Component;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;

@JsonPropertyOrder({"id", "components"})
public class Topology {
    private String id;
    private ArrayList<Component> components;

    public Topology(String id) {
        this.id = id;
    }

    public Topology() {
    }

    public Topology(String id, ArrayList<Component> components) {
        this.id = id;
        this.components = components;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Component> getComponents() {
        return components;
    }

    public void setComponents(ArrayList<Component> components) {
        this.components = components;
    }

    @Override
    public String toString() {
        return "ID = " + id + ",\n{\n" + components.toString() + "\n";
    }

    @Override
    public boolean equals(Object obj) {
        Topology t2 = (Topology) obj;
        return id.equals(t2.id) && components.equals(t2.components);
    }
}
