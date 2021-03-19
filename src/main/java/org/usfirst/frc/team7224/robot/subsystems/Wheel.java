package org.usfirst.frc.team7224.robot.subsystems;


import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import org.usfirst.frc.team7224.robot.RobotMap;
import org.usfirst.frc.team7224.robot.commands.WheelAction;

import edu.wpi.first.wpilibj.command.Subsystem;



/**
 *
 */
public class Wheel extends Subsystem {

      private final WPI_TalonSRX wheelmotor = RobotMap.wheelTalonSRX13;
  
    
    
      public void initDefaultCommand() {
          setDefaultCommand(new WheelAction());
      }
    
      public void setupWheel() {
        wheelmotor.set(ControlMode.PercentOutput,0);
             }
    
  
         /**
       * sets the hook motor speed  -1 to +1
       */
      public void setWheelSpeed(double wspeed) {
        wheelmotor.set(wspeed);
        }
    }




  


