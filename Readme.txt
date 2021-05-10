MAX_NO_VEHICLE specifies at a time number of vehicles can be present in the tunnel. It can be increased or decreased as per need by 
changing the value of MAX_NO_VEHICLE.

Vehicles are kept in a Priority blocking queue. They can come in the tunnel from right or left direction which will be generated 
randomly.
When a vehicle is going inside the tunnel, signal will be red, so that no other vehicle can enter in the tunnel at that time.
When vehicle will leave the tunnel signal will be green.

This program can be run in Eclipse, IntelliJ Idea, or running from command line.
For Eclipse path should be workspace/TunnelController/src/controller/ControllerTunnel.java

For command line compilation:
javac *.java
cd ..


For command line run the code:
java.controller.ControllerTunnel


hello world
