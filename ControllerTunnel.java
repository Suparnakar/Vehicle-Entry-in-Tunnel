package controller;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.Queue;


public class ControllerTunnel {

	private static State signal;
	private static ReentrantLock lock = new ReentrantLock();
	public static final int MAX_NO_VEHICLE = 10;// at any time
	static Queue<Vehicle> queue= new PriorityBlockingQueue<>();
	
	public String entry;

	public enum State {  // state of signal
		Green, Red;
	}

	synchronized void checkingSignal() {
		if (signal.equals(State.Red)) {

		}
	}
	public void arrive(Vehicle car, String direction) {

		System.out.println(
				"Car " + car.id + " arrived in " + direction + " direction");
		lock.lock();
		signal = State.Red;

	}

	public void depart(Vehicle car) {
		System.out.println("Car " + car.id + " is leaving ");
		lock.unlock();
		signal = State.Green;

	}

	public static void main(String[] args) throws InterruptedException {
		ControllerTunnel con = new ControllerTunnel();
		

		for (int i = 0; i < MAX_NO_VEHICLE; i++) {
			Vehicle car = new Vehicle(i, con);
			queue.add(car);
			car.start();
			
			Thread.sleep(650);
		}
	}

	static class Vehicle extends Thread implements Comparable<Vehicle> {
		private int id;
		String entry; // either "right" or "left" 
		ControllerTunnel controller;

		Vehicle(int id, ControllerTunnel controller) {
			this.id = id;
			this.controller = controller;
			Random rnd = new Random(System.nanoTime());
			if (rnd.nextBoolean() == true) {
				entry = "left";
			} else {
				entry = "right";
			}
		}
		@Override
		public void run() {
			controller.arrive(this, this.entry);

			try {
				System.out.println("Car " + id + " is crossing the tunnel ");
				System.out.println("Signal is " + signal);
				sleep(1000); // Traveling time

			} catch (InterruptedException e) {
				e.printStackTrace();
			} ;
			controller.depart(this);
			System.out.println("Signal is " + signal);
		}
		
		@Override
		public int compareTo(Vehicle that) {
			return -(this.id - that.id);
		}

	}

}
