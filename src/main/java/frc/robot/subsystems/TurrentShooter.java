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


/**
 * Add your docs here.
 */
public class TurrentShooter extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public TalonSRX TurrentShooter;

  public TurrentShooter (){
    TurrentShooter = new TalonSRX(RobotMap.TurrentShooter_ID);


    TurrentShooter.configFactoryDefault();
    TurrentShooter.setNeutralMode(NeutralMode.Brake);
    TurrentShooter.configContinuousCurrentLimit(30);
    TurrentShooter.configPeakCurrentLimit(0);
    TurrentShooter.enableCurrentLimit(true);
    TurrentShooter.setInverted(false);    
  }
  
  public void ShootPowerCell() {
    TurrentShooter.set(ControlMode.PercentOutput, 1.0);
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
