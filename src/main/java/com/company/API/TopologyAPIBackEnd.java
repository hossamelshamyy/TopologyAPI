package com.company.API;

import com.company.Topology.Components.Prototypes.Component;
import com.company.Topology.Topology;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class TopologyAPIBackEnd implements TopologyAPI {
    private final ArrayList<Topology> topos;

    protected TopologyAPIBackEnd() {
        topos = new ArrayList<>();
    }

    @Override
    public Topology readJSON(String fileName) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Topology topology = mapper.readValue(new File(fileName), Topology.class);
        topos.add(topology);
        return topology;

    }

    @Override
    public boolean writeJSON(String topologyID) throws IOException {
        for (Topology t : topos) {
            if (t.getId().equals(topologyID)) {
                ObjectMapper mapper = new ObjectMapper();
                mapper.writeValue(new File(t.getId() + ".json"), t);
                topos.remove(t);
                return true;
            }
        }
        return false;
    }

    @Override
    public ArrayList<Topology> queryTopologies() {
        return topos;
    }

    @Override
    public boolean deleteTopology(String topologyID) {
        for (Topology t : topos) {
            if (t.getId().equals(topologyID)) {
                topos.remove(t);
                return true;
            }
        }
        return false;
    }

    @Override
    public ArrayList<Component> queryDevices(String topologyID) {
        for (Topology t : topos) {
            if (t.getId().equals(topologyID)) {
                return t.getComponents();
            }
        }
        return null;
    }

    @Override
    public ArrayList<Component> queryDevicesWithNetlistNode(String topologyID, String NetlistNodeID) {
        ArrayList<Component> components = new ArrayList<>();
        for (Topology t : topos)
            if (t.getId().equals(topologyID))
                for (Component c : t.getComponents())
                    if (c.getNetlist().containsValue(NetlistNodeID))
                        components.add(c);

        return components;
    }
}
