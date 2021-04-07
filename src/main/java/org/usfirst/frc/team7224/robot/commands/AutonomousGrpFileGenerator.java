package org.usfirst.frc.team7224.robot.commands;

import java.util.*;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team7224.robot.Point;

public class AutonomousGrpFileGenerator extends CommandGroup {

     public AutonomousGrpFileGenerator() {
          addParallel(new AutonomousCmdRunIntake());
          addSequential(new AutonomousCmdTrajectoryFollowerFileGenerator(new Point(0, 0, 0), new Point(154, -40, 30), "PathB1_1"));
          addSequential(new AutonomousCmdTrajectoryFollowerFileGenerator(new Point(0, 0, 0), new Point(32, 55, 0), "PathB1_2"));
          addSequential(new AutonomousCmdTrajectoryFollowerFileGenerator(new Point(0, 0, 0), new Point(28, 0, 0), "PathB1_3"));
          addSequential(new AutonomousCmdTrajectoryFollowerFileGenerator(new Point(0, 0, 0), new Point(105, -90, -55), "PathB1_4"));
     }

}