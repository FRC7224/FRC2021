package org.usfirst.frc.team7224.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team7224.robot.Robot;
import org.usfirst.frc.team7224.robot.RobotConstants;

import edu.wpi.first.wpilibj.Timer;

/**
 *
 */
public class ShifterAction extends Command {

     public ShifterAction() {

          requires(Robot.shifter);

     }

     // Called just before this Command runs the first time
     protected void initialize() {
          RobotConstants.shiftOpenState = false;

     }

     // Called repeatedly when this Command is scheduled to run
     protected void execute() {

          if (Robot.oi.joystick1.getRawButton(RobotConstants.kshiftbutton)) {
               Robot.shifter.openShifter();
               RobotConstants.shiftOpenState = true;
          } else { // toggle off
               Robot.shifter.closeShifter();
               RobotConstants.shiftOpenState = false;
          }

          // ****************************** Shifter
          // *******************************************
          /*
           * if (Robot.oi.joystick1.getRawButton(RobotConstants.kshiftbutton)) { if
           * (closeTimer.get() == 0) { if (RobotConstants.shiftOpenState == false) {
           * RobotConstants.shiftOpenState = true; Robot.shifter.openShifter();
           * 
           * } else { // If the shooter mode was on then toggle off
           * Robot.shifter.closeShifter(); RobotConstants.shiftOpenState = false; } // end
           * sate check } // end timer // Start Timer to make sure the toggle happens only
           * once closeTimer.start(); } // End joystick check
           * 
           * if (closeTimer.get() >= RobotConstants.kcloseTimer_timer) {
           * closeTimer.stop(); closeTimer.reset(); }
           */

          // SmartDashboard.putBoolean("Shifter", RobotConstants.shiftOpenState);

     } // end exectute

     // Make this return true when this Command no longer needs to run execute()
     protected boolean isFinished() {
          return false;
     }

     // Called once after isFinished returns true
     protected void end() {
     }

     // Called when another command which requires one or more of the same
     // subsystems is scheduled to run
     protected void interrupted() {
     }
}
