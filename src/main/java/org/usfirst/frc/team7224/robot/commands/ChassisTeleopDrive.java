


package org.usfirst.frc.team7224.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team7224.robot.Robot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;




/**
 *
 */
public class ChassisTeleopDrive extends Command {


    public ChassisTeleopDrive() {
    	 requires(Robot.chassis);

   }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
  		
    	 Robot.chassis.setupDrive();
     }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
    	     double forward = -Robot.chassis.deadZone(Robot.oi.joystick1.getY()); // forward
             double turn = -Robot.chassis.deadZone(Robot.oi.joystick1.getX()); // turn
             if (forward >= 0) {
                 forward = forward*forward;             
             } else {
                 forward = -(forward*forward);
             }
             if (turn >= 0) {
                 turn = turn*turn;
              } else {
                 turn = -(turn*turn);
             }

             Robot.chassis.autoshift();
             Robot.chassis.arcadeDrive(forward, turn);
             Robot.chassis.displayChasisData();
     //		SmartDashboard.putNumber("Y", forward);
    //		SmartDashboard.putNumber("X", turn);
    	
    		

    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }
}
