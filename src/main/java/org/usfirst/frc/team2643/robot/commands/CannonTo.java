/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2643.robot.commands;

import org.usfirst.frc.team2643.robot.Robot;
import org.usfirst.frc.team2643.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class CannonTo extends Command {
  boolean isFinished = false; 
  double cannonPosition; 
  
  //TODO test CannonTo after potentiometer values and directions are determined
  public CannonTo(double position) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.cannon);
    cannonPosition = position; 
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    if(Robot.cannon.getPotentiometer() == RobotMap.cannonUpperLimit || Robot.cannon.getPotentiometer() == RobotMap.cannonLowerLimit){
      isFinished = true; 
    }
    isFinished = false; 
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if(Robot.cannon.getPotentiometer() < cannonPosition){
      Robot.cannon.cannonUp();
    }else if(Robot.cannon.getPotentiometer() > cannonPosition){
      Robot.cannon.cannonDown(); 
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if(Robot.cannon.getPotentiometer() == cannonPosition || Robot.cannon.getPotentiometer() == RobotMap.cannonUpperLimit || Robot.cannon.getPotentiometer() == RobotMap.cannonLowerLimit){
      isFinished = true; 
    }else{
      isFinished = false; 
    }
    return isFinished; 
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.cannon.cannonStop(); 
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
