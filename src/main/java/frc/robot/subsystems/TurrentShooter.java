/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import frc.robot.RobotMap;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.DriveTrain;

import edu.wpi.first.networktables.NetworkTableInstance;



/**
 * Add your docs here.
 */
public class TurrentShooter extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private Limelight limelight = Limelight.getInstance();
  public boolean m_LimelightTurnSuccess = false;

  public static final TurrentShooter instance = new TurrentShooter();

  public static TurrentShooter getInstance(){
    return instance;
  }

  public TalonSRX TurrentShooter;

  double tv = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tv").getDouble(0);
  double tx = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx").getDouble(0);
  double ty = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ty").getDouble(0);
  double ta = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ta").getDouble(0);

  public TurrentShooter (){
    TurrentShooter = new TalonSRX(RobotMap.TurrentShooter_ID);


    TurrentShooter.configFactoryDefault();
    TurrentShooter.setNeutralMode(NeutralMode.Brake);
    TurrentShooter.configContinuousCurrentLimit(30);
    TurrentShooter.configPeakCurrentLimit(0);
    TurrentShooter.enableCurrentLimit(true);
    TurrentShooter.setInverted(false);    
  }
  public double kp = -0.1f;
  public double minCommand = 0.05f; 

  
  public void ShootPowerCell() {

    double heading_error = tx;
    double steeringAdjust = 0.0f;

    limelight.UpdateLimelightTraking();


      //limelight.SteeringAdjust();
    if (tx > 1.0){
      steeringAdjust = kp*heading_error - minCommand;
    } 
    else if (tx < 1.0){
      steeringAdjust = kp*heading_error + minCommand;
      
    }


    
    TurrentShooter.set(ControlMode.PercentOutput, 1.0);
    
    double leftCommand =+ steeringAdjust;
    double rightCommand =- steeringAdjust;
    DriveTrain.mDrive.tankDrive(leftCommand, rightCommand);
  }
  public void StopShootCargo() {
    TurrentShooter.set(ControlMode.PercentOutput, 0.0);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
