package org.usfirst.frc.team7224.robot;

/**
 * This class contains all the variables and constants used by the developers
 * for the robot.
 *
 * 
 */

public class RobotConstants {

	// IMPORTANT NOTICE
	//
	// Please make sure, that all the constants you insert here, are in the
	// right area. If no matches, you create your own one.

	// Joystick 1 constants
	public static double kdeadzone = 0.1; // updated by MG
	public static int kinitShooter = 1;
	public static int kshiftbutton = 2;
	public static int kintakeinbutton = 9;
	public static int kintakeoutbutton = 4;
	// public static int kzeroResetbutton = 4;
	public static int kwheelgraboutbutton = 9;
	public static int kwheelgrabonbutton = 6;
	public static int kWinchButtonA = 10;
	public static int kWinchButtonB = 5;
	public static int kpreButton = 7;
	public static int kShootOverideButton = 8;

	// Simple Drive
	// public static double simpleDriveTime = 0.0;

	// Chassis
	public static boolean kenablePID = true;
	public static double Kp = 0.0002; // .005 0.012
	public static double Ki = 0.0; // .1 0.0025
	public static double Kd = 0.05; // .1
	public static double kgyroPIDErrorTolerance = 1.0; // in degrees
	public static double gyroPIDOutput = 0.0;
	public static double kshiftRateUp = 1200;
	public static double kshiftRateDown = 800;
	public static boolean shiftOpenState = false;

	// Wheel
	public static boolean wheelOpenState = false;
	public static double kwheelcloseTimer_timer = .3;

	// Autonomous
	public static int TrajectorySegments;
	public static boolean isTrajectory = false;
	public static int kencodermode = 0;

	// Winch
	public static double kmaxWinchSpeed = 1.0;
	public static double kminWinchSpeed = 0.0;
	public static boolean WinchState = false;

	//
	public static final int kSlotIdx_w = 0;
	public static final int kallowableCloseLoopError_w = 300;
	public static final int kPIDLoopIdx_w = 0;
	public static final int kTimeoutMs_w = 10;
	public static final double kSlowwinch_w = 0.5;
	public static final double kNormalwinch_w = 2.5;
	public static double kMaxSpeed_w = kNormalwinch_w;
	public static final double kStopSpeed_w = 0.0;
	public static double targetPositionRotations_w = 0;
	public static double kwinchManualSensitivity_w = 2000;
	public static double kwinch_Zero_HT_w = 0;
	// public static double kwinch_FieldHT_w = 5000;
	// public static double kwinch_SwitchHT_w = 130000;
	// public static double kwinch_ScaleHT_w = 280000;
	public static double kwinchMinHt_w = 0;
	// public static double kwinchpreHt_w = 320000;
	// public static double kwinchMaxHt_w = 320000;
	public static double kwinchPIDF_w = 0.0;
	public static double kwinchPIDP_w = 0.045;
	public static double kwinchPIDI_w = 0.0001;
	public static double kwinchPIDD_w = 0.4;
	public static int kREMOTE_1_w = 0;

	// Intake
	public static double kmaxIntakeSpeed = 0.7;
	public static double kminIntakeSpeed = 0.0;

	// Turn
	public static double kturnspeed = 0.18;

	// Driverstation
	public static String gameData = "XXX";

	// Shifter
	public static double kcloseTimer_timer = .3;

	// Elevator
	public static double kelvspeed = 0.5;

	// Hook speed
	public static double khookspeedscale = 0.2;

	// Shooter Constants

	public static int zone;
	public static double zone1shootertargetspeed1 = 23000;
	public static double zone1shootertargetspeed2 = 13000;
	public static double zone2shootertargetspeed1 = 23000;
	public static double zone2shootertargetspeed2 = 13000;
	public static double zone3shootertargetspeed1 = 23000;
	public static double zone3shootertargetspeed2 = 13000;
	public static double zone4shootertargetspeed1 = 23000;
	public static double zone4shootertargetspeed2 = 13000;
	public static double z1shootspeed1 = zone1shootertargetspeed1;
	public static double z1shootspeed2 = zone1shootertargetspeed2;
	public static double z2shootspeed1 = zone2shootertargetspeed1;
	public static double z2shootspeed2 = zone2shootertargetspeed2;
	public static double z3shootspeed1 = zone3shootertargetspeed1;
	public static double z3shootspeed2 = zone3shootertargetspeed2;
	public static double z4shootspeed1 = zone4shootertargetspeed1;
	public static double z4shootspeed2 = zone4shootertargetspeed2;
	public static double shooterTolerance = 300.0;
	public static double shooterTimer_timer = 1.2;
	public static boolean shooterMode = false;
	public static int kPIDLoopIdx = 0;
	public static int kTimeoutMs = 30;
	public static double kshoot1P = 0.25;
	public static double kshoot1I = 0.001;
	public static double kshoot1D = 20;
	public static double kshoot1F = 1023.0 / 7200.0;
	//
	public static double kshoot2P = 0.25;
	public static double kshoot2I = 0.001;
	public static double kshoot2D = 20;
	public static double kshoot2F = 1023.0 / 7200.0;
	// public static double kshootF = 0.25;

	// * PID Gains may have to be adjusted based on the responsiveness of control
	// loop.
	// kF: 1023 represents output value to Talon at 100%, 7200 represents Velocity
	// units at 100% output

	// kP kI kD kF Iz PeakOut */

	// public final static Gains kGains_Velocit = new Gains( 0.25, 0.001, 20,
	// 1023.0/7200.0, 300, 1.00);

}
