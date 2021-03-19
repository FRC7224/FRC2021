package org.usfirst.frc.team7224.robot.commands;



import org.usfirst.frc.team7224.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutonomousCmdSimpleDrive extends Command {

	double power;
	double drivetime;
	Timer timeout;

	/**
	 * starts a command that drives robot for a specific amount of time
	 * 
	 * @param motorpower
	 *            the motor power to drive from -1.0 to 1.0
	 * @param time
	 *            how long to drive in seconds
	 */
	public AutonomousCmdSimpleDrive (double motorpower, double time) {
		power = motorpower;
		drivetime = time;
		timeout = new Timer();
		requires(Robot.chassis);
	}

	@Override
	protected void initialize() {
		timeout.start();
		Robot.chassis.setupDrive();
	}

	@Override
	protected void execute() {
		Robot.chassis.displayChasisData();
		Robot.chassis.arcadeDrive(power, 0);
		SmartDashboard.putNumber("simpledrive timer", timeout.get() );
		
	}

	@Override
	protected boolean isFinished() {
		if (timeout.get() >= drivetime) {
			return true;
		} else {
			return false;
		}
       
}
	
	@Override
	protected void end() {
		Robot.chassis.arcadeDrive(0, 0);
		Robot.chassis.resetgyro();
		Robot.chassis.resetEncoders();
		SmartDashboard.putNumber("simpledrive DONE", timeout.get() );
		timeout.stop();
		timeout.reset();
	}

	@Override
	protected void interrupted() {
		end();
	}

}
