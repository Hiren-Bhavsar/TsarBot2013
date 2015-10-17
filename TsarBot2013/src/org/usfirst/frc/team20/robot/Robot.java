
package org.usfirst.frc.team20.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.IterativeRobot;

public class Robot extends IterativeRobot {
    
	Pneumatics pneu = new Pneumatics();
	Motors motors = new Motors();
	Sensors sense = new Sensors();
	OperatorControls opControls = new OperatorControls();
	DriverControls driveControls = new DriverControls();
	
    public void robotInit() {
    	pneu.compress.setClosedLoopControl(true);
    	pneu.compress.start();
    	pneu.indeXer.set(Value.kForward);
    	pneu.inverTer.set(Value.kReverse);
    }

   
    public void autonomousPeriodic() {

    }

    
    public void teleopInit(){
    	pneu.compress.setClosedLoopControl(true);
    	pneu.compress.start();
    }
    
    public void teleopPeriodic() {
    	opControls.opControls();
    	driveControls.driveControls();
    }
    
    
    public void testPeriodic() {
    
    }
    
}
