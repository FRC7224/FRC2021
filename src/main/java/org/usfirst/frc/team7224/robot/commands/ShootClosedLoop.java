
package org.usfirst.frc.team7224.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.Preferences;

import org.usfirst.frc.team7224.robot.Robot;
import org.usfirst.frc.team7224.robot.RobotConstants;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

// Needed for Button Toggle Code
import edu.wpi.first.wpilibj.Timer;

/**
 *
 */
public class ShootClosedLoop extends Command {

    Preferences prefs;
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


    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {

        double motorSpeed1;
        double motorSpeed2;

        // if button 1 is pressed
        SmartDashboard.putBoolean("shoot mode ", RobotConstants.shooterMode);

        final double timetorun = RobotConstants.shooterTimer_timer;

        // cahnge zones
        if (Robot.oi.joystick1.getRawButtonPressed(RobotConstants.zoneup)) {
            if (RobotConstants.zone < 4) {
                RobotConstants.zone = RobotConstants.zone + 1;
            }
        }

        if (Robot.oi.joystick1.getRawButtonPressed(RobotConstants.zonedown)) {
            if (RobotConstants.zone > 1) {
                RobotConstants.zone = RobotConstants.zone - 1;
            }
        }

        SmartDashboard.putNumber("Zone", RobotConstants.zone);

        if (Robot.oi.joystick1.getRawButton(RobotConstants.kinitShooter)) {
            SmartDashboard.putNumber("shoot mode ", timetorun);

            switch (RobotConstants.zone) {
                case 1: // Zone 1 Green
                    motorSpeed1 = RobotConstants.zone1shootertargetspeed1;
                    motorSpeed2 = RobotConstants.zone1shootertargetspeed2;
                    break;
                case 2: // Zone 2 Yellow
                    motorSpeed1 = RobotConstants.zone2shootertargetspeed1;
                    motorSpeed2 = RobotConstants.zone2shootertargetspeed2;
                    break;
                case 3: // Zone 3 Blue
                    motorSpeed1 = RobotConstants.zone3shootertargetspeed1;
                    motorSpeed2 = RobotConstants.zone3shootertargetspeed2;
                    break;
                case 4: // Zone 4 red
                    motorSpeed1 = RobotConstants.zone4shootertargetspeed1;
                    motorSpeed2 = RobotConstants.zone4shootertargetspeed2;
                    break;
                default: // Zone 4
                    motorSpeed1 = RobotConstants.zone4shootertargetspeed1;
                    motorSpeed2 = RobotConstants.zone4shootertargetspeed2;
                    break;
            }

            if (timer.get() <= timetorun) {
                SmartDashboard.putNumber("shoot mode inside ", timetorun);
                SmartDashboard.putNumber("timer ", timer.get());
                Robot.shoot.setShootSpeed(motorSpeed1, motorSpeed2);

            } else {
                Robot.shoot.setShootSpeed(motorSpeed1, motorSpeed2);
                Robot.shoot.setelvSpeed(RobotConstants.kelvspeed);
                Robot.shoot.setturnSpeed(RobotConstants.kturnspeed);
                SmartDashboard.putNumber("shoot mode else ", timetorun);
            }
        } else

        {
            Robot.shoot.setShootSpeed(0, 0);
            Robot.shoot.setelvSpeed(0);
            Robot.shoot.setturnSpeed(0);
            timer.reset();
        }

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        // timer.stop();
        // timer.reset();
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
