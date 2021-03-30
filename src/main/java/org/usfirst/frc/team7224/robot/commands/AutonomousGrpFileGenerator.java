package org.usfirst.frc.team7224.robot.commands;

import java.util.*;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team7224.robot.Point;

public class AutonomousGrpFileGenerator extends CommandGroup {

     public AutonomousGrpFileGenerator() {
          // List<Point> A1points = Arrays.asList(new Point(30, 105, 0), new Point(60,102, 20), new Point(90, 90, 0),
          //      new Point(144, 72, 30), new Point(204, 48, -45), new Point(180, 84, -110), new Point(156, 132, -90),
          //      new Point(210, 150, 0), new Point(336, 90, 0));

          // addSequential(new AutonomousCmdTrajectoryFollowerFileGenerator(A1points, "PathA1_")); // drive straight

          // List<Point> A2points = Arrays.asList(new Point())
// 
          // List<Point> B1points = Arrays.asList(new Point(30, 90, 0), new Point(72, 108,-30));
          // String fileName = "PathB1_1";
          // List <Point> B1points = Arrays.asList(new Point(72, 108,-30), new Point(96, 108,0));
          // String fileName = "PathB1_2";
          // List<Point> B1points =  Arrays.asList(new Point(96, 108,0), new Point(144, 72, 45));
          // String fileName = "PathB1_3";
          // List<Point> B1points = Arrays.asList(new Point(144, 72, 45), new Point(168, 60, 0));
          // String fileName = "PathB1_4";
          // List<Point> B1points = Arrays.asList(new Point(168, 60, 0), new Point(204, 108, -45)); 
          // String fileName = "PathB1_5";
          // List<Point> B1points = Arrays.asList(new Point(204, 108, -45), new Point(276, 132, 10));
          // String fileName = "PathB1_6";
          List<Point> B1points = Arrays.asList(new Point(276, 132, 10), new Point(336, 90, 0));
          String fileName = "PathB1_7";

          addSequential(new AutonomousCmdTrajectoryFollowerFileGenerator(B1points, fileName));
     }

}