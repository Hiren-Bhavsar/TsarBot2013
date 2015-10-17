package org.usfirst.frc.team20.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Joystick;

public class DriverControls {
	
	public Joystick driveJoy = new Joystick(0);
	Pneumatics pneu = new Pneumatics();
	Motors motors = new Motors();
	Sensors sense = new Sensors();
	
	public void driveControls(){
		
		double speed = driveJoy.getRawAxis(0);
		double turnValue = driveJoy.getRawAxis(4);
		double lTurn = driveJoy.getRawAxis(2);
		double rTurn = driveJoy.getRawAxis(3);
		
		if(sense.leftSide.get() && !sense.rightSide.get()){
			motors.backLeft.set(0);
			motors.frontLeft.set(0);
			motors.backRight.set(-.5);
			motors.frontRight.set(-.5);
		}else if(!sense.leftSide.get() && sense.rightSide.get()){
			motors.backLeft.set(-.5);
			motors.frontLeft.set(-.5);
			motors.backRight.set(0);
			motors.frontRight.set(-0);
		}else if(sense.leftSide.get() && sense.rightSide.get() && speed ==0){
			motors.backLeft.set(0);
			motors.frontLeft.set(0);
			motors.backRight.set(0);
			motors.frontRight.set(0);
		}
		
		double leftEquation = speed + turnValue - lTurn + rTurn;
		double rightEquation = speed - turnValue - rTurn + lTurn;
		
		motors.backLeft.set(leftEquation);
		motors.frontLeft.set(leftEquation);
		
		motors.backRight.set(rightEquation);
		motors.frontRight.set(rightEquation);
		
		if(driveJoy.getRawButton(1)){
			pneu.leftLifter.set(Value.kForward);
			pneu.rightLifter.set(Value.kForward);
		}
		if(driveJoy.getRawButton(4)){
			pneu.leftLifter.set(Value.kReverse);
			pneu.rightLifter.set(Value.kReverse);
		}
	}

}
