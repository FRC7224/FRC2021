
package org.usfirst.frc.team7224.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import org.usfirst.frc.team7224.robot.Robot;
import org.usfirst.frc.team7224.robot.RobotConstants;
import org.usfirst.frc.team7224.robot.RobotMap;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


//Needed for Button Toggle Code
import edu.wpi.first.wpilibj.Timer;

/**
 *
 */
public class ShootClosedLoop extends Command {

// Used for Button Toggle Code
private final Timer timer = new Timer();

    public ShootClosedLoop() {

        requires(Robot.shoot);

        // RobotConstants.shootertargetspeed
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        Robot.shoot.setupShooter();
        RobotConstants.shooterMode = false;
        timer.start();
  //      timer.reset();
  //      timer.reset();

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        // if button 1 is pressed
        SmartDashboard.putBoolean("shoot mode ", RobotConstants.shooterMode);
    //    Robot.shoot.setShootSpeed(0, 0);
    //    Robot.shoot.setelvSpeed(0);
    //    Robot.shoot.setturnSpeed(0);
        final double timetorun = RobotConstants.shooterTimer_timer;

    if (Robot.oi.joystick1.getRawButton(RobotConstants.kinitShooter)) {
        SmartDashboard.putNumber("shoot mode ", timetorun);
       // timer.start();
           if (timer.get() <= timetorun) {
            SmartDashboard.putNumber("shoot mode inside ", timetorun);
            SmartDashboard.putNumber("timer ", timer.get());
           Robot.shoot.setShootSpeed(RobotConstants.shootertargetspeed1, RobotConstants.shootertargetspeed2);
            } else {
             Robot.shoot.setShootSpeed(RobotConstants.shootertargetspeed1, RobotConstants.shootertargetspeed2);
             Robot.shoot.setelvSpeed(RobotConstants.kelvspeed);
             Robot.shoot.setturnSpeed(RobotConstants.kturnspeed);
             SmartDashboard.putNumber("shoot mode else ", timetorun);
            }
    } else {
        Robot.shoot.setShootSpeed(0,0);
        Robot.shoot.setelvSpeed(0);
        Robot.shoot.setturnSpeed(0);
        timer.reset();
    } 
  
    

    // }
 
     // If the shooterTimer is greater than value then reset it
     // Note: Tune the value to better timing of when the button is pressed
     // and the next pressed
     // if (shooterTimer.get() >= RobotConstants.shooterTimer_timer) {
     //    shooterTimer.stop();
     //    shooterTimer.reset();
    // }
 
 
 }
 
 // Make this return true when this Command no longer needs to run execute()
 protected boolean isFinished() {
      //    timer.stop();
      //    timer.reset();
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
