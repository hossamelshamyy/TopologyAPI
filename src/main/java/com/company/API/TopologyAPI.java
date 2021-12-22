package com.company.API;


import com.company.Topology.Components.Prototypes.Component;
import com.company.Topology.Topology;

import java.io.IOException;
import java.util.ArrayList;

public interface TopologyAPI {

    Topology readJSON(String fileName) throws IOException;

    boolean writeJSON(String topologyID) throws IOException;

    ArrayList<Topology> queryTopologies();

    boolean deleteTopology(String topologyID);

    ArrayList<Component> queryDevices(String topologyID);

    ArrayList<Component> queryDevicesWithNetlistNode(String topologyID, String NetlistNodeID);
}
