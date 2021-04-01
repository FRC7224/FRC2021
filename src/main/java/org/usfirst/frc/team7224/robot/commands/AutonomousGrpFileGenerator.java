package org.usfirst.frc.team7224.robot.commands;

import java.util.*;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team7224.robot.Point;

public class AutonomousGrpFileGenerator extends CommandGroup {

     public AutonomousGrpFileGenerator() {
          addSequential(new AutonomousCmdTrajectoryFollowerFileGenerator(new Point(0, 0, 0), new Point(154, -40, 30), "PathB1_1"));
          addSequential(new AutonomousCmdTrajectoryFollowerFileGenerator(new Point(0, 0, 0), new Point(32, 52, 0), "PathB1_2"));
          addSequential(new AutonomousCmdTrajectoryFollowerFileGenerator(new Point(0, 0, 0), new Point(24, 0, 0), "PathB1_3"));
          addSequential(new AutonomousCmdTrajectoryFollowerFileGenerator(new Point(0, 0, 0), new Point(24, 0, -30), "PathB1_4"));
     }

}