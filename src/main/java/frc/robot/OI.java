/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.robot.Input.*;
//import frc.robot.Constants;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());

  private static final LogitechAttack3Joystick LeftStick = new LogitechAttack3Joystick(RobotMap.LeftStickPort);
  private static final LogitechAttack3Joystick RightStick = new LogitechAttack3Joystick(RobotMap.RightStickPort);
  private static final LogitechController Gamepad = new LogitechController(RobotMap.GamepadPort);

  public void RegisterControls() {
    
    
  }

  //Controls for the Robot (Driving)
  public static double getLeftThrottleInput() {
    return LeftStick.getYAxis();
  }

  public static double getRightThrottleInput() {
    return RightStick.getYAxis(); 
  }

  public static double getLeftSteeringInput() {
    return LeftStick.getXAxis();
  }

  public static double getRightSteeringInput() {
    return RightStick.getXAxis();
  }

  //Left
  public static double getLeftThrottleInputInverted() {
    return LeftStick.getYAxisInverted();
  }

  public static double getRightThrottleInputInverted() {
    return RightStick.getYAxisInverted();
  }

  public static double getLeftSteeringInputInverted() {
    return LeftStick.getXAxisInverted();
  }

  public static double getRightSteeringInputInverted() {
    return RightStick.getXAxisInverted();
  }


  
}
