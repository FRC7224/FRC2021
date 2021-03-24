
package org.usfirst.frc.team7224.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team7224.robot.Robot;
import org.usfirst.frc.team7224.robot.RobotConstants;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class IntakeAction extends Command {

    public IntakeAction() {
        requires(Robot.intake);

    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {

        Robot.intake.setupIntake();
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() { // check in first
        double intakespeed = 0;
        if (Robot.oi.joystick1.getRawButton(RobotConstants.kintakeinbutton)) {
            intakespeed = RobotConstants.kmaxIntakeSpeed;
            Robot.intake.setIntakeMotor(intakespeed);
            // Robot.shoot.setturnSpeed(turnspeed);
        } else { // toggle off
            Robot.intake.setIntakeMotor(0);
            // Robot.shoot.setturnSpeed(0);
        }

        SmartDashboard.putNumber("Z Intake", intakespeed);
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
