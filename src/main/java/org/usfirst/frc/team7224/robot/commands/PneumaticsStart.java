/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team7224.robot.commands;

import org.usfirst.frc.team7224.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class PneumaticsStart extends Command {

    public PneumaticsStart() {
        requires(Robot.pneumatics);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        Robot.pneumatics.startCompressor();
        // SmartDashboard.putNumber("Tele ninit ph",0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        Robot.pneumatics.startCompressor();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        // Robot.pneumatics.stopCompressor();
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
