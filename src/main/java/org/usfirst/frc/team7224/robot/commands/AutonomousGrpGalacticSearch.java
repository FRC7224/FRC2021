package org.usfirst.frc.team7224.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousGrpGalacticSearch extends CommandGroup {

    public AutonomousGrpGalacticSearch() { 

        // vision logic determines with case we're in
        int PathType = 2;
        switch (PathType) {
            case 0:
            // all files for path a1
            addSequential(new AutonomousCmdTrajectoryFollowerTwoFixFile("PathA1_1"));
            break;
            case 1:
            // all files for path a2
            addSequential(new AutonomousCmdTrajectoryFollowerTwoFixFile("PathA2_1"));
            break;
            case 2:
            // all files for path b1
            for (int i = 1; i < 8; i++){
                addSequential(new AutonomousCmdTrajectoryFollowerTwoFixFile(String.format("/home/lvuser/PathB1_%d.csv", i)));
            }
           
            break;
            case 3:
            // all files for path b2
            addSequential(new AutonomousCmdTrajectoryFollowerTwoFixFile("PathB2_1"));
            break;
        }
        
    }

}
