# Vehicle-Entry-in-Tunnel
A highway has a single lane tunnel. However, due to construction on a nearby road, all vehicles
have to use the tunnel. Due to the size of the tunnel, a vehicle can safely enter the tunnel if and only
if there are no other vehicles entering the tunnel. To prevent accidents, sensors are installed at each
end of the tunnel which notify a controller system about the arrival and departure of vehicles in the
tunnel, in either direction. The controller uses the sensor input to control signal lights at either end of
the tunnel.

Assumptions

 Each vehicle can be represented by a thread that calls Arrive() and Depart() functions in the
controller and passes arguments to indicate direction of travel

 Arrive() can safely stop an arriving vehicle by changing the correct signal light to Red and
block the calling thread.

Implement the above scenario, i.e., the controller program using mutexes.
Your solution should correctly handle rush hour, during which many vehicles approach the tunnel
from both directions.
