/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.networktables.NetworkTableInstance;

/**
 * Add your docs here.
 */
public class Limelight extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public static final Limelight instance = new Limelight();

  public static Limelight getInstance(){
    return instance;
  }

  public boolean m_LimelightHasValidTarget = false;

  public boolean m_LimelightTurnSuccess = false;

  public double kp = -0.1f;
  public double minCommand = 0.05f; 

  double tv = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tv").getDouble(0);
  double tx = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx").getDouble(0);
  double ty = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ty").getDouble(0);
  double ta = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ta").getDouble(0);

  public void UpdateLimelightTraking () {

    if (tv == 1.0) {
      m_LimelightHasValidTarget = true;
      // m_LimelightDriveCommand = 0.0;
      // m_LimelightSteerCommand = 0.0;
      return;
    } else {
      m_LimelightHasValidTarget = false;
    }
  }

  public void SteeringAdjust() {

    double heading_error = tx;
    double steeringAdjust = 0.0f;

    if (tx > 1.0){
      steeringAdjust = kp*heading_error - minCommand;
      m_LimelightTurnSuccess = true;
    }
    else if (tx < 1.0){
      steeringAdjust = kp*heading_error + minCommand;
    }

    double leftCommand =+ steeringAdjust;
    double rightCommand =- steeringAdjust;
    DriveTrain.mDrive.tankDrive(leftCommand, rightCommand);
  }





  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
