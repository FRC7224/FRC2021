package org.usfirst.frc.team7224.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team7224.robot.Robot;

import org.usfirst.frc.team7224.robot.RobotConstants;

public class AutonomousCmdRunIntake extends Command {

    public AutonomousCmdRunIntake() {
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
        Robot.intake.setIntakeMotor(RobotConstants.kmaxIntakeSpeed);
        Robot.shoot.setturnSpeed(RobotConstants.kturnspeed * .8);

    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
    }

    @Override
    protected void interrupted() {
    }

}
