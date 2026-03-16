package oop.multi2;

public class Test01이동수단정보 {
	public static void main(String[] args) {
		int type = 1;
		int action = 1;
		
		Vehicle vehicle = null;
		Chargable charge = null;
		Refuelable refuel = null;
		Autonomous auto = null;
		Flyable fly = null;
		Sailable sail = null;
		//테슬라
		if(type == 1) {
			vehicle = new Tesla("테슬라");
			charge = new Tesla("dd");
		}
		if(action == 1) {
			vehicle.move();
			vehicle.startEngine();
			vehicle.stopEngine();
//			((Chargable) vehicle).charge();
			charge.charge();
		}
		
		//드론
//		vehicle = new Drone("무인드론");
//		vehicle.move();
//		vehicle.startEngine();
//		vehicle.stopEngine();
//		charge.charge();
//		auto.autoDrive();
//		auto.autoParking();
//		fly.fly();
//		
//		//TankerShip
//		vehicle = new TankerShip("대형 유조선");
//		vehicle.move();
//		vehicle.startEngine();
//		vehicle.stopEngine();
//		refuel.refuel();
//		sail.sail();
//		
//		//JetSki
//		vehicle = new JetSki("제트스키");
	}
}
