package org.usfirst.frc.team20.robot;

import edu.wpi.first.wpilibj.Talon;

public class Motors {
	//Drive Train Talons
	public Talon frontLeft = new Talon(1);	
	public Talon frontRight = new Talon(3);	
	public Talon backLeft = new Talon(2);	
	public Talon backRight = new Talon(4);	
//	public Talon midLeft = new Talon(9);	
//	public Talon midRight = new Talon(8);
	
	//Collector Talon
	public Talon collectorTal = new Talon(7);
	
	//Belt Conveyer Talon
	public Talon conveyerTal = new Talon(6);
	
	//Shooter Talon
	public Talon shooterTal = new Talon(5);
}
