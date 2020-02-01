/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.TurrentShooter;;


public class TargetandShoot extends Command {


  private Timer shootTimer = new Timer();
  private boolean doneshooting = false;
  private Limelight limelight = Limelight.getInstance();
  private TurrentShooter turrentShooter = TurrentShooter.getInstance();



  public TargetandShoot() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);

  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    shootTimer.start();
    turrentShooter.ShootPowerCell();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {


    if (shootTimer.get() >= 1.0) {
      shootTimer.stop();
      shootTimer.reset();
      turrentShooter.StopShootCargo();
      doneshooting = true;
      
    }
    else {
      doneshooting = false;
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if (doneshooting == true) {
      return true;
    }
    else {
      return false;
    }
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
