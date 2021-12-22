# Topology API

## Table of Contents
+ [About](#about)
+ [Why JAVA](#java)
+ [Used Technologies](#built_using)
+ [Getting Started](#getting_started)
+ [Usage](#usage)

## About <a name = "about"></a>
Simple API to deal with Json formatted Topology and perfrom some basic operations.

## Why JAVA <a name = "java"></a>
Java has been choosen to write the API because of Jackson library which is a library that handles Json files and also supports ****Serialization and Deserialization**** meaning that it can convert java object to Json file and vise-versa, in case we want to add any component or property simply we make a class corrospoding to the component we want and add the desired Jackson Annotations and that's it!

## ⛏️ Used Technologies <a name = "built_using"></a>
- [IntelliJ](https://www.jetbrains.com/idea/) - IDE
- [Jackson](https://github.com/FasterXML/jackson) - Json parser (****Serialization and Deserialization****)
- [Maven](https://maven.apache.org/) - Build tool
- [JUnit](https://junit.org/junit5/) - Testig
- [Code analysis] - Code analysis tools builtin IntelliJ

## Getting Started <a name = "getting_started"></a>
First you need to create an instance of the API 
```
TopologyAPI api = APIBuilder.createTopologyAPI();
```
Note that it is a **Singleton** design pattern which means that this API object will be the same in the whole project.
___
Then you can do the different operations available in the API.

## Usage <a name = "usage"></a>
Read the given Json file in the parameter and return object of Topology.
```
Topology t = api.readJSON("file.json");
```
Write specific topology stored in the API's memory to a local path named with topologyID.json, Returns True if the operation done successfully.
```
api.writeJSON("id");
// file will be named id.json and will be located in the local directory
```
Query about all topologies are currently in the API's memory.
```
ArrayList<Topology> t = api.queryTopologies();
```
Delete a given topologyID from the API's memory, Return true if deleted successfully.
```
deleteTopology("id");
```
Query about all devices are in given topologyID in the API's memory.
```
ArrayList<Component> t = api.queryDevices("id");
```
Query about which devices are connected to netlist node in given topologyID in the API's memory.
```
ArrayList<Component> t = api.queryDevicesWithNetlistNode("node","id");
```

### You will find a demo in the Main class.

