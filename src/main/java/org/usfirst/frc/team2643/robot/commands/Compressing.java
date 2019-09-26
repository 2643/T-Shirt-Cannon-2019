/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2643.robot.commands;

import org.usfirst.frc.team2643.robot.Robot;
import org.usfirst.frc.team2643.robot.RobotMap;

import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj.command.Command;

public class Compressing extends Command {

  public Compressing() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.cannon);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    RobotMap.relay.set(Value.kForward);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return Robot.cannon.fullyPressurized();
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    RobotMap.relay.set(Value.kOff);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end(); 
    
    /* 
     * Sanjana: 
     *    The compressor will keep compressing until the pressure is at 120 psi,
     *    but can be interrupted to fire the cannon
     *    OPERATOR CHECK IF THE PRESSURE IS ABOVE WORKING PSI
     *    I DON'T KNOW WHAT WILL HAPPEN OTHERWISE
     */

  }
}
