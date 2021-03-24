
package org.usfirst.frc.team7224.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.Preferences;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import org.usfirst.frc.team7224.robot.Robot;
import org.usfirst.frc.team7224.robot.RobotConstants;
import org.usfirst.frc.team7224.robot.RobotMap;

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
        double z1shootspeed1;
        double z1shootspeed2;
        double z2shootspeed1;
        double z2shootspeed2;
        double z3shootspeed1;
        double z3shootspeed2;
        double z4shootspeed1;
        double z4shootspeed2;

        // if button 1 is pressed
        SmartDashboard.putBoolean("shoot mode ", RobotConstants.shooterMode);

        final double timetorun = RobotConstants.shooterTimer_timer;

        // cahnge zones
        double zChange = -Robot.chassis.deadZone(Robot.oi.joystick1.getY()); // forward
        if ((zChange > 0.5) & (RobotConstants.zone < 4)) {
            RobotConstants.zone = RobotConstants.zone + 1;
        } else if ((zChange > 0.5) & (RobotConstants.zone < 0)) {
            RobotConstants.zone = RobotConstants.zone - 1;
        }
        SmartDashboard.putNumber("Zone", RobotConstants.zone);

        prefs = Preferences.getInstance();
        z1shootspeed1 = prefs.getDouble("Zone 1 Motor 1", RobotConstants.zone1shootertargetspeed1);
        z1shootspeed2 = prefs.getDouble("Zone 1 Motor 2", RobotConstants.zone1shootertargetspeed2);
        z2shootspeed1 = prefs.getDouble("Zone 2 Motor 1", RobotConstants.zone2shootertargetspeed1);
        z2shootspeed2 = prefs.getDouble("Zone 2 Motor 2", RobotConstants.zone2shootertargetspeed2);
        z3shootspeed1 = prefs.getDouble("Zone 3 Motor 1", RobotConstants.zone3shootertargetspeed1);
        z3shootspeed2 = prefs.getDouble("Zone 3 Motor 2", RobotConstants.zone3shootertargetspeed2);
        z4shootspeed1 = prefs.getDouble("Zone 4 Motor 1", RobotConstants.zone4shootertargetspeed1);
        z4shootspeed2 = prefs.getDouble("Zone 4 Motor 2", RobotConstants.zone4shootertargetspeed2);

        if (Robot.oi.joystick1.getRawButton(RobotConstants.kinitShooter)) {
            SmartDashboard.putNumber("shoot mode ", timetorun);

            if (timer.get() <= timetorun) {
                SmartDashboard.putNumber("shoot mode inside ", timetorun);
                SmartDashboard.putNumber("timer ", timer.get());
                switch (RobotConstants.zone) {
                    case 1: // Zone 1 Green
                        Robot.shoot.setShootSpeed(z1shootspeed1,z1shootspeed2);
                        break;
                    case 2: // Zone 2 Yellow
                    Robot.shoot.setShootSpeed(z2shootspeed1,z2shootspeed2);
                        break;
                    case 3: // Zone 1 Blue
                    Robot.shoot.setShootSpeed(z3shootspeed1,z3shootspeed2);
                        break;
                    case 4: // Zone 1 red
                    Robot.shoot.setShootSpeed(z4shootspeed1,z4shootspeed2);
                        break;
                    default: // Zone 1
                    Robot.shoot.setShootSpeed(z4shootspeed1,z4shootspeed2);
                        break;
                }
            } else {
                // Robot.shoot.setShootSpeed(RobotConstants.shootertargetspeed1,
                // RobotConstants.shootertargetspeed2);
                Robot.shoot.setelvSpeed(RobotConstants.kelvspeed);
                Robot.shoot.setturnSpeed(RobotConstants.kturnspeed);
                SmartDashboard.putNumber("shoot mode else ", timetorun);
            }
        } else {
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
