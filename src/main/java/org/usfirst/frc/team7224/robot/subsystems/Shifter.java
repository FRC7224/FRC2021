



	package org.usfirst.frc.team7224.robot.subsystems;


	import org.usfirst.frc.team7224.robot.RobotMap;
	import org.usfirst.frc.team7224.robot.commands.ShifterAction;

	import edu.wpi.first.wpilibj.Solenoid;
	import edu.wpi.first.wpilibj.command.Subsystem;



	/**
	 *
	 */
	public class Shifter extends Subsystem {


	    private final Solenoid OpenCloseShifter = RobotMap.pneumaticsSolenoid0;


	      public void initDefaultCommand() {
	       setDefaultCommand(new ShifterAction());
	    }

	        public void openShifter() {
	        //
	        // opens shifter/put in high gear
	        	OpenCloseShifter.set(true);
	    }

	    public void closeShifter() {
	        //
	        // closes shifter/put in low gare
	    	   OpenCloseShifter.set(false);
	    }
	}
