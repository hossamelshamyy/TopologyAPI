package com.company.Topology.Components.Resistor;

import com.company.Topology.Components.Prototypes.Component;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Map;

@JsonPropertyOrder({"type", "id", "resistance", "netlist"})
public class Resistor extends Component {

    @JsonProperty("resistance")
    private Resistance resistance;

    @JsonCreator
    public Resistor(@JsonProperty("id") String id, @JsonProperty("netlist") Map<String, String> netlist, @JsonProperty("resistance") Resistance resistance) {
        super(id, netlist);
        type = "resistor";
        this.resistance = resistance;
    }

    public Resistance getResistance() {
        return resistance;
    }

    public void setResistance(Resistance resistance) {
        this.resistance = resistance;
    }

    @Override
    public String toString() {
        return "Type = " + type + ", ID = " + getId() + resistance.toString() + ", netlist = " + getNetlist().toString() + "\n";
    }

    @Override
    public boolean equals(Object obj) {
        Resistor r = (Resistor) obj;
        return resistance.equals(r.resistance) && getId().equals(r.getId()) && getNetlist().equals(r.getNetlist());
    }
}
