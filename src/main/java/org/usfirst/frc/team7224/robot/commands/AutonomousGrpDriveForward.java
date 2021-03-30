package org.usfirst.frc.team7224.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousGrpDriveForward extends CommandGroup {

    public AutonomousGrpDriveForward() { // Drives forward
        addSequential(new AutonomousCmdTrajectoryFollowerTwoFixFile("driveForward.csv"));
    }

}
