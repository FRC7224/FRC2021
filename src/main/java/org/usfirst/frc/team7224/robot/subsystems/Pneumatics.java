package org.usfirst.frc.team7224.robot.subsystems;

import org.usfirst.frc.team7224.robot.RobotMap;
import org.usfirst.frc.team7224.robot.commands.PneumaticsStart;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;


public class Pneumatics extends Subsystem {

    private final Compressor compressor = RobotMap.pneumaticsCompressor;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {

        setDefaultCommand(new PneumaticsStart());

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    public void stopCompressor() {
        compressor.stop();
    }

    public void startCompressor() {
        compressor.start();
        // SmartDashboard.putNumber("got to start", 0);
    }
}
