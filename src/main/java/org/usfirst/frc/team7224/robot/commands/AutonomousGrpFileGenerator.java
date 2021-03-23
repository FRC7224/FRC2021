package org.usfirst.frc.team7224.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousGrpFileGenerator extends CommandGroup{
	
	public AutonomousGrpFileGenerator(){
		

	addSequential(new AutonomousCmdTrajectoryFollowerFileGenerator(0, 0, 0,140,0, 0)); // drive straight
 //  	addSequential(new AutonomousCmdTrajectoryFollowerFileGenerator(0, 0, 0,270, 14, 60));// rightToScale
// addSequential(new AutonomousCmdTrajectoryFollowerFileGenerator(0, 0, 0,270,-14, -60));// leftToScale
 //   	addSequential(new AutonomousCmdTrajectoryFollowerFileGenerator(0, 0, 0,124,14, 70));// righttoswitch
  //  	addSequential(new AutonomousCmdTrajectoryFollowerFileGenerator(0, 0, 0,124,-14, -70));// lefttoswitch
 // 	addSequential(new AutonomousCmdTrajectoryFollowerFileGenerator(0, 0, 0,107,-12,0));// Centertorightswitch
//   	addSequential(new AutonomousCmdTrajectoryFollowerFileGenerator(0, 0, 0,107,90,0));// CenterToLEftSwitch
  //  	addSequential(new AutonomousCmdTrajectoryFollowerFileGenerator(0, 0, 0,212,170,45));// CenterToLEftSwitch
		}

}