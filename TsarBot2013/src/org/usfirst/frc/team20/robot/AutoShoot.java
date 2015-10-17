package org.usfirst.frc.team20.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;

public class AutoShoot {

	Sensors sense = new Sensors();
	Motors motors = new Motors();
	Pneumatics pneu = new Pneumatics();

	public void fire(double rpmSet, int shooterState) {

		int frisbeeCount = 0;
		double currentRPM = 60 * (sense.flywheelEnc.get() / 120);

		while (shooterState == 1) {
			if (currentRPM < rpmSet - 50 && shooterState == 1) {
				motors.shooterTal.set(1);
				shooterState = 1;
			} else if (currentRPM < rpmSet + 50 && shooterState == 1) {
				motors.shooterTal.set(.2);
				shooterState = 1;
			} else if (shooterState != 0 && currentRPM < rpmSet + 50
					&& currentRPM > rpmSet - 50) {
				shooterState = 2;
				break;
			} else {
				motors.shooterTal.set(0);
				shooterState = 0;
				break;
			}
		}
		if (shooterState == 2 && frisbeeCount < 5) {
			frisbeeCount++;
			motors.conveyerTal.set(1);
			if (frisbeeCount == 4) {
				pneu.indeXer.set(DoubleSolenoid.Value.kReverse);
			}
		} else {
			motors.conveyerTal.set(0);
			pneu.indeXer.set(DoubleSolenoid.Value.kForward);
			shooterState = 0;
		}

		if (shooterState == 0) {
			motors.conveyerTal.set(0);
			motors.shooterTal.set(0);
			pneu.indeXer.set(DoubleSolenoid.Value.kForward);
			pneu.inverTer.set(DoubleSolenoid.Value.kReverse);
		}
	}
}