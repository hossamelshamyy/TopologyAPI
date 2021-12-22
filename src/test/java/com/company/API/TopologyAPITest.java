package com.company.API;

import com.company.Topology.Components.Nmos.M1;
import com.company.Topology.Components.Nmos.Nmos;
import com.company.Topology.Components.Prototypes.Component;
import com.company.Topology.Components.Resistor.Resistance;
import com.company.Topology.Components.Resistor.Resistor;
import com.company.Topology.Topology;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class TopologyAPITest {

    static TopologyAPI api;
    static String jsonTestFile;
    static Topology expectedTopology;
    static Topology result;

    // In the setUp function we create the API and make a Topology object similar to the data.json attached to compare between them in our tests
    @BeforeAll
    static void setUp() throws IOException {
        api = APIBuilder.createTopologyAPI();
        jsonTestFile = "data.json";

        Map<String, String> netlistRes = new HashMap<>();
        netlistRes.put("t1", "vdd");
        netlistRes.put("t2", "n1");

        Map<String, String> netlistNmos = new HashMap<>();
        netlistNmos.put("drain", "n1");
        netlistNmos.put("gate", "vin");
        netlistNmos.put("source", "vss");

        expectedTopology = new Topology("top1");
        Resistor res = new Resistor("res1", netlistRes, new Resistance(100, 10, 1000));
        Nmos nmos = new Nmos("m1", netlistNmos, new M1(1.5, 1, 2));
        ArrayList<Component> components = new ArrayList<Component>();
        components.add(res);
        components.add(nmos);
        expectedTopology.setComponents(components);

        TopologyAPITest.result = api.readJSON(jsonTestFile);

    }


    // Recreate the API and add one topology in the memory after each test
    @AfterEach
    void tearDown() throws IOException {
        APIBuilder.deleteTopologyAPI();
        TopologyAPITest.api = APIBuilder.createTopologyAPI();
        TopologyAPITest.api.readJSON(TopologyAPITest.jsonTestFile);
    }

    @Test
    void readJSON() {
        Assertions.assertEquals(TopologyAPITest.result, expectedTopology);
    }


    @Test
    void writeJSON() throws IOException {
        Assertions.assertTrue(api.writeJSON("top1"));
    }

    @Test
    void queryTopologies() {
        Assertions.assertEquals(1, api.queryTopologies().size());
        Assertions.assertEquals(api.queryTopologies().get(0), expectedTopology);
    }

    @Test
    void deleteTopology() {
        Assertions.assertTrue(api.deleteTopology(expectedTopology.getId()));
        Assertions.assertEquals(0, api.queryTopologies().size());
    }

    @Test
    void queryDevices() {
        Assertions.assertEquals(api.queryDevices(TopologyAPITest.result.getId()), expectedTopology.getComponents());
    }

    @Test
    void queryDevicesWithNetlistNode() {
        Assertions.assertEquals(api.queryDevicesWithNetlistNode(expectedTopology.getId(), "n1"), expectedTopology.getComponents());
    }
}