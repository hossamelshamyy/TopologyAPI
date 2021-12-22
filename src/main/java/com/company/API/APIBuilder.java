package com.company.API;


public class APIBuilder {
    private static TopologyAPIBackEnd backEnd;

    public static TopologyAPIBackEnd createTopologyAPI() {
        if (APIBuilder.backEnd == null)
            APIBuilder.backEnd = new TopologyAPIBackEnd();
        return APIBuilder.backEnd;
    }

    public static void deleteTopologyAPI() {
        APIBuilder.backEnd = null;
    }
}
