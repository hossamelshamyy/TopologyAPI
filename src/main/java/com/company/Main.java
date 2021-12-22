package com.company;

import com.company.API.APIBuilder;
import com.company.API.TopologyAPI;
import com.company.API.Topology.Components.Nmos.M1;
import com.company.API.Topology.Components.Nmos.Nmos;
import com.company.API.Topology.Components.Prototypes.Component;
import com.company.API.Topology.Components.Resistor.Resistance;
import com.company.API.Topology.Components.Resistor.Resistor;
import com.company.API.Topology.Topology;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// In the main function we are making a Topology object, then write it to a file result1.json, then reading it again into an object, then compare between the two object
// To ensure that the serialization and deserialization works perfectly
public class Main {

    public static void main(String[] args) throws IOException {

        TopologyAPI api = APIBuilder.createTopologyAPI();
        ObjectMapper mapper = new ObjectMapper();

        // Make a Topology object and write it to result.json file
        Map<String, String> netlistRes = new HashMap<>();
        netlistRes.put("t1", "t1");
        netlistRes.put("t2", "t3");

        Map<String, String> netlistNmos = new HashMap<>();
        netlistNmos.put("11", "1");
        netlistNmos.put("22", "2");
        netlistNmos.put("33", "3");

        Resistor res = new Resistor("res1", netlistRes, new Resistance(5, 1.3, 10));
        Nmos nmos = new Nmos("nmos1", netlistNmos, new M1(5, 10, 15));

        Topology t1 = new Topology();
        t1.setId("top11");
        ArrayList<Component> coms = new ArrayList<>();
        coms.add(res);
        coms.add(nmos);
        t1.setComponents(coms);

        mapper.writeValue(new File("result.json"), t1);


        // Read the file we have written
        Topology t2 = null;
        t2 = api.readJSON("result.json");


        // Comparing the two objects, note that we have already overridden the "equals" method
        System.out.println(t1.equals(t2));

    }
}

