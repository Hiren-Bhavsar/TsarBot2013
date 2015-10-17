package org.usfirst.frc.team20.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;

public class Sensors {

	public Gyro gyro = new Gyro(0);
	
	//Encoders
	public Encoder leftMidEnc = new Encoder(0, 1);
	public Encoder rightMidEnc = new Encoder(2, 3);
	public Encoder flywheelEnc = new Encoder(4,5);
	
	//Switches 
	DigitalInput leftSide = new DigitalInput(7);
	DigitalInput rightSide = new DigitalInput(8);
}