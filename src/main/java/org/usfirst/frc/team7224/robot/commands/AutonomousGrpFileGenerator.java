package org.usfirst.frc.team7224.robot.commands;

import java.util.*;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team7224.robot.Point;

public class AutonomousGrpFileGenerator extends CommandGroup{
     
     public AutonomousGrpFileGenerator(){
          List<Point> points = Arrays.asList(new Point(0, 0, 0),  new Point(100, 0, 0), new Point(200, 10, 10));

     addSequential(new AutonomousCmdTrajectoryFollowerFileGenerator(points, "PathA1")); // drive straight
 //       addSequential(new AutonomousCmdTrajectoryFollowerFileGenerator(0, 0, 0,270, 14, 60));// rightToScale
// addSequential(new AutonomousCmdTrajectoryFollowerFileGenerator(0, 0, 0,270,-14, -60));// leftToScale
 //        addSequential(new AutonomousCmdTrajectoryFollowerFileGenerator(0, 0, 0,124,14, 70));// righttoswitch
  //       addSequential(new AutonomousCmdTrajectoryFollowerFileGenerator(0, 0, 0,124,-14, -70));// lefttoswitch
 //      addSequential(new AutonomousCmdTrajectoryFollowerFileGenerator(0, 0, 0,107,-12,0));// Centertorightswitch
//        addSequential(new AutonomousCmdTrajectoryFollowerFileGenerator(0, 0, 0,107,90,0));// CenterToLEftSwitch
  //       addSequential(new AutonomousCmdTrajectoryFollowerFileGenerator(0, 0, 0,212,170,45));// CenterToLEftSwitch
          }

}