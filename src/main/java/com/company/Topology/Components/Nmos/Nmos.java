package com.company.Topology.Components.Nmos;

import com.company.Topology.Components.Prototypes.Component;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Map;

@JsonPropertyOrder({"id", "m(1)", "netlist"})
public class Nmos extends Component {
    @JsonProperty("m(1)")
    private M1 m1;

    @JsonCreator
    public Nmos(@JsonProperty("id") String id, @JsonProperty("netlist") Map<String, String> netlist, @JsonProperty("m(1)") M1 m1) {
        super(id, netlist);
        type = "nmos";
        this.m1 = m1;
    }

    public M1 getM1() {
        return m1;
    }

    public void setM1(M1 m1) {
        this.m1 = m1;
    }

    @Override
    public String toString() {
        return "Type = " + type + ", ID = " + getId() + m1.toString() + ", netlist = " + getNetlist().toString() + "\n";

    }

    @Override
    public boolean equals(Object obj) {
        Nmos r = (Nmos) obj;
        return m1.equals(r.m1) && getId().equals(r.getId()) && getNetlist().equals(r.getNetlist());
    }
}
