package org.usfirst.frc.team20.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;

public class Pneumatics {
	
	public Compressor compress = new Compressor();	
	
	public DoubleSolenoid trayLifter = new DoubleSolenoid(0,1);
	public DoubleSolenoid indeXer = new DoubleSolenoid(7,8);
	public DoubleSolenoid inverTer = new DoubleSolenoid(5,6);
	public DoubleSolenoid leftLifter = new DoubleSolenoid(3,4);
	public DoubleSolenoid rightLifter = new DoubleSolenoid(3,4);
	
	
}
