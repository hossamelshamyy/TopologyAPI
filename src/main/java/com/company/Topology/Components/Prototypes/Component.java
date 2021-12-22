package com.company.Topology.Components.Prototypes;


import com.company.Topology.Components.Nmos.Nmos;
import com.company.Topology.Components.Resistor.Resistor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.Map;


@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Resistor.class, name = "resistor"),
        @JsonSubTypes.Type(value = Nmos.class, name = "nmos")
})
@JsonIgnoreProperties("type")

public abstract class Component {
    @JsonProperty("type")
    protected String type;
    @JsonProperty("id")
    String id;
    @JsonProperty("netlist")
    Map<String, String> netlist;

    public Component(String id, Map<String, String> netlist) {
        this.id = id;
        this.netlist = netlist;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Map<String, String> getNetlist() {
        return netlist;
    }

    public void setNetlist(Map<String, String> netlist) {
        this.netlist = netlist;
    }

}
