package org.usfirst.frc.team7224.robot.commands;

import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

import org.usfirst.frc.team7224.robot.Robot;
import org.usfirst.frc.team7224.robot.RobotConstants;

import edu.wpi.first.wpilibj.command.Command;
import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;
import jaci.pathfinder.followers.EncoderFollower;
import jaci.pathfinder.modifiers.TankModifier;
import org.usfirst.frc.team7224.robot.Point;

public class AutonomousCmdTrajectoryFollowerFileGenerator extends Command {

  edu.wpi.first.wpilibj.Timer timeout;
  Timer t;
  int gyrowait;
  double lasttime;
  double timelapse;
  String FileName;
  EncoderFollower left;
  EncoderFollower right;
  private static double inchesToMeter = 0.0254;
  // This has a max size of three
  Waypoint[] waypoints = new Waypoint[2];

  public AutonomousCmdTrajectoryFollowerFileGenerator(Point startPoint, Point endPoint, String fileName) {
    requires(Robot.chassis);
    waypoints[0] = new Waypoint(startPoint.X * inchesToMeter, 
      startPoint.Y * inchesToMeter, Math.toRadians(startPoint.D));
    waypoints[1] = new Waypoint(endPoint.X * inchesToMeter, 
      endPoint.Y * inchesToMeter, Math.toRadians(endPoint.D));
    FileName = fileName;
  }

  @Override
  protected void initialize() {
    // SmartDashboard.putNumber("files writer", 0);
    // int startindex = RobotConstants.startPositionChooser;
    // waypoints[0] = new Waypoint (0,0,0);
    // waypoints[1] = new Waypoint(RobotConstants.autostartposition[startindex][0]*
    // inchesToMeter, RobotConstants.autostartposition[startindex][1]*
    // inchesToMeter,
    // Math.toRadians(RobotConstants.autostartposition[startindex][2]));

    timeout = new edu.wpi.first.wpilibj.Timer();
    timeout.start();
    Robot.chassis.setupDrive();
    Robot.chassis.brakemode(true);
    RobotConstants.isTrajectory = true;
    RobotConstants.TrajectorySegments = 0;
    // Example
    // Waypoint[] points = new Waypoint[] {
    // new Waypoint(-4, -1, Pathfinder.d2r(-45)), // Waypoint @ x=-4, y=-1, exit
    // angle=-45 degrees
    // new Waypoint(-2, -2, 0), // Waypoint @ x=-2, y=-2, exit angle=0 radians
    // new Waypoint(0, 0, 0) // Waypoint @ x=0, y=0, exit angle=0 radians
    // };
    //
    // Waypoint[] points = new Waypoint[]{
    // new Waypoint(0,0, Pathfinder.d2r(0)),
    // new Waypoint(5,0, Pathfinder.d2r(0))
    // };

    Waypoint[] points = waypoints;
    // SmartDashboard.putNumber("files writer2", 0);

    // Trajectory.Config config = new
    // Trajectory.Config(Trajectory.FitMethod.HERMITE_CUBIC,
    // Trajectory.Config.SAMPLES_LOW, 0.05, 8.0, 2.0, 60.0);
    // Prepare the Trajectory for Generation.
    //
    // Arguments:
    // Fit Function: FIT_HERMITE_CUBIC or FIT_HERMITE_QUINTIC
    // Sample Count: PATHFINDER_SAMPLES_HIGH (100 000)
    // PATHFINDER_SAMPLES_LOW (10 000)
    // PATHFINDER_SAMPLES_FAST (1 000)
    // Time Step: 0.001 Seconds
    // Max Velocity: 15 m/s
    // Max Acceleration: 10 m/s/s
    // Max Jerk: 60 m/s/s/s
    // Trajectory.Config config = new
    // Trajectory.Config(Trajectory.FitMethod.HERMITE_CUBIC,
    // Trajectory.Config.SAMPLES_LOW,0.05, .35, .3, .4);
    Trajectory.Config config = new Trajectory.Config(Trajectory.FitMethod.HERMITE_CUBIC, Trajectory.Config.SAMPLES_LOW,
        0.05, 1.2, .5, .4);

    Trajectory trajectory = Pathfinder.generate(points, config);
    File myFile = new File(String.format("/home/lvuser/%s.csv", FileName));
    Pathfinder.writeToCSV(myFile, trajectory);
    // File myFile = new File("/home/lvuser/leftToScale.traj");
    // Pathfinder.writeToFile(myFile, trajectory);

    double wheelbase_width = .61; // MG updated

    // Create the Modifier Object
    TankModifier modifier = new TankModifier(trajectory).modify(wheelbase_width);

    left = new EncoderFollower(modifier.getLeftTrajectory());
    right = new EncoderFollower(modifier.getRightTrajectory());

    // Encoder Position is the current, cumulative position of your encoder.
    // If you're using an SRX, this will be the
    // 'getEncPosition' function.
    // 100 is the amount of encoder ticks per full revolution
    // 20 ticks per rev * 5:1 gear ratio = 100
    // Wheel Diameter is the diameter of your wheels (or pulley for a track system)
    // in meters
    // 6" * .0254 = .1016

    left.configureEncoder(Robot.chassis.getLeftEncoderPosition(), 365, 0.1524);
    right.configureEncoder(Robot.chassis.getRightEncoderPosition(), 365, 0.1525);

    // The first argument is the proportional gain. Usually this will be quite high
    // The second argument is the integral gain. This is unused for motion profiling
    // The third argument is the derivative gain. Tweak this if you are unhappy with
    // the tracking of the trajectory
    // The fourth argument is the velocity ratio. This is 1 over the maximum
    // velocity you provided in the
    // trajectory configuration (it translates m/s to a -1 to 1 scale that your
    // motors can read)
    // The fifth argument is your acceleration gain. Tweak this if you want to get
    // to a higher or lower speed quicker
    left.configurePIDVA(0.7, 0.0, 0.00, 0.6, 0);
    right.configurePIDVA(0.7, 0.0, 0.00, 0.6, 0);

    t = new Timer();
    Robot.chassis.brakemode(true);
    Robot.chassis.resetgyro();
    t.schedule(new TimerTask() {
      // Sample setup
      // double l = left.calculate(encoder_position_left);
      // double r = right.calculate(encoder_position_right);
      //
      // double gyro_heading = ... your gyro code here ... // Assuming the gyro is
      // giving a value in degrees
      // double desired_heading = Pathfinder.r2d(left.getHeading()); // Should also be
      // in degrees
      //
      // double angleDifference = Pathfinder.boundHalfDegrees(desired_heading -
      // gyro_heading);
      // double turn = 0.8 * (-1.0/80.0) * angleDifference;
      //
      // setLeftMotors(l + turn);
      // setRightMotors(r - turn);
      ////// End sample setup

      public void run() {
        lasttime = edu.wpi.first.wpilibj.Timer.getFPGATimestamp();
        timelapse = edu.wpi.first.wpilibj.Timer.getFPGATimestamp() - lasttime;
        if (!left.isFinished() || !right.isFinished()) {

          double l = left.calculate(Robot.chassis.getLeftEncoderPosition());
          double r = right.calculate(Robot.chassis.getRightEncoderPosition());
          double gyro_heading = -Robot.chassis.getGyroAngle(); // Assuming the gyro is giving a value in degrees
          double desired_heading = Pathfinder.r2d(left.getHeading()); // Should also be in degrees
          double angleDifference = Pathfinder.boundHalfDegrees(desired_heading - gyro_heading);
          double turn = 0.8 * (-1.0 / 80.0) * angleDifference;
          Robot.chassis.tankDrive((l + turn), (r - turn));
          /*
           * Robot.chassis.tankDrive(-(l + turn),-(r - turn));
           * SmartDashboard.putNumber("tra head", desired_heading);
           * SmartDashboard.putNumber("tra angle Difference", angleDifference);
           * SmartDashboard.putNumber("tra gyro 2", -Robot.chassis.getGyroAngle());
           * SmartDashboard.putNumber("tra right", r);
           * SmartDashboard.putNumber("tra left", l); SmartDashboard.putNumber("Turn",
           * turn); SmartDashboard.putDouble("tra right", -(r - turn));
           * SmartDashboard.putDouble("tra left", -(l + turn));
           * SmartDashboard.putNumber("tra encoder right",
           * Robot.chassis.getRightEncoderPosition());
           * SmartDashboard.putNumber("tra encodeer left",
           * Robot.chassis.getLeftEncoderPosition());
           */

        } else {
          Robot.chassis.tankDrive(0, 0);
          left.reset();
          right.reset();
        }
        // SmartDashboard.putNumber("tra gyro 2", Robot.chassis.getGyroAngle());
        // System.out.println("r "+ r);
        // System.out.println("l "+ l);
        // SmartDashboard.putNumber("tra encoder right",
        // Robot.chassis.getRightEncoderPosition());
        // SmartDashboard.putNumber("tra encodeer left",
        // Robot.chassis.getLeftEncoderPosition());
        // SmartDashboard.putNumber("time lapse", timelapse);
        // System.out.println(" Run specific task at given time." +
        // System.currentTimeMillis());
        // System.out.println(" Total time." + RobotConstants.TrajectorySegments*.05);
      }

    }, 0, 50); // end timed task 0 delay, execute every 50 mSec
    left.reset();
    right.reset();
    Robot.chassis.resetEncoders();
    Robot.chassis.displayChasisData();

  }

  @Override
  protected void execute() {
  }

  @Override
  protected boolean isFinished() {
    if (left.isFinished() || right.isFinished() || timeout.get() > 11) {
      Robot.chassis.resetEncoders();
      return true;
    }
    return false;
  }

  @Override
  protected void end() {
    timeout.stop();
    timeout.reset();
    t.cancel();
    RobotConstants.isTrajectory = false;
    Robot.chassis.brakemode(false);
  }

  @Override
  protected void interrupted() {
    end();

  }

}
