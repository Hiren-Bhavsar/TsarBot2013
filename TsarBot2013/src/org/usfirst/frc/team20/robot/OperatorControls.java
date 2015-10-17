package org.usfirst.frc.team20.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Joystick;

public class OperatorControls {

	public Joystick opJoy = new Joystick(1);
	AutoShoot autoShoot = new AutoShoot();
	Pneumatics pneu = new Pneumatics();
	Motors motors = new Motors();
	Sensors sense = new Sensors();

	public void opControls() {
		int povVal = opJoy.getPOV();
		double conveyerSpeed = opJoy.getRawAxis(0);

		motors.conveyerTal.set(conveyerSpeed);

		if (opJoy.getRawButton(5)) {
			autoShoot.fire(1200, 1);
		}
		if (opJoy.getRawButton(6)) {
			pneu.inverTer.set(Value.kForward);
			autoShoot.fire(1200, 1);
		}
		if (opJoy.getRawButton(1)) {
			motors.collectorTal.set(1);
		}
		if (opJoy.getRawButton(4)) {
			motors.collectorTal.set(-1);
		}
		if (opJoy.getRawButton(2)) {
			motors.collectorTal.set(0);
		}
		if (opJoy.getRawButton(3)) {
			motors.collectorTal.set(0);
		}

		if (povVal == 0) {
			pneu.inverTer.set(Value.kForward);
		}
		if (povVal == 180) {
			pneu.inverTer.set(Value.kReverse);
		}
		if (povVal == 90) {
			pneu.indeXer.set(Value.kForward);
		}
		if (povVal == 270) {
			pneu.indeXer.set(Value.kReverse);
		}

		if (opJoy.getRawAxis(2) != 0) {
			motors.shooterTal.set(1);
		} else {
			motors.shooterTal.set(0);
		}
		
		if(opJoy.getRawButton(7)){
			pneu.trayLifter.set(Value.kReverse);
			pneu.indeXer.set(Value.kReverse);
		}
		if(opJoy.getRawButton(8)){
			pneu.trayLifter.set(Value.kForward);
			pneu.indeXer.set(Value.kForward);
		}
	}
}
