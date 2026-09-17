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
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Compressing extends CommandBase {

  public Compressing() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    addRequirements(Robot.cannon);
  }

  // Called just before this Command runs the first time
  @Override
  public void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
    RobotMap.relay.set(Value.kForward);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
    return Robot.cannon.fullyPressurized();
  }

  // Called once after isFinished returns true
  @Override
  public void end(boolean interrupted) {
    RobotMap.relay.set(Value.kOff);
  }
}
