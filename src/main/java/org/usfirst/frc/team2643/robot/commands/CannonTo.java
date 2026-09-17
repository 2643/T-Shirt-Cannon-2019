/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2643.robot.commands;

import org.usfirst.frc.team2643.robot.Robot;
import org.usfirst.frc.team2643.robot.RobotMap;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class CannonTo extends CommandBase {
  boolean isFinished = false; 
  double cannonPosition; 
  
  public CannonTo(double position) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    addRequirements(Robot.cannonPositioner);
    cannonPosition = position; 
  }

  // Called just before this Command runs the first time
  @Override
  public void initialize() {
    if(Robot.cannonPositioner.getPotentiometer() >= RobotMap.cannonLowerLimit
        || Robot.cannonPositioner.getPotentiometer() <= RobotMap.cannonUpperLimit) {
      isFinished = true;
    }
    isFinished = false; 
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
    if(Robot.cannonPositioner.getPotentiometer() > cannonPosition){
      Robot.cannonPositioner.cannonUp();
    }else if(Robot.cannonPositioner.getPotentiometer() < cannonPosition) {
      Robot.cannonPositioner.cannonDown(); 
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
    if(Robot.cannonPositioner.getPotentiometer() > (cannonPosition - 1) && Robot.cannonPositioner.getPotentiometer() < (cannonPosition + 1)){
      isFinished = true; 
    }else if(Robot.cannonPositioner.getPotentiometer() == RobotMap.cannonUpperLimit || Robot.cannonPositioner.getPotentiometer() == RobotMap.cannonLowerLimit){
      isFinished = true; 
    }else{
      isFinished = false; 
    }
    return isFinished; 
  }

  // Called once after isFinished returns true
  @Override
  public void end(boolean interrupted) {
    Robot.cannonPositioner.cannonStop();
  }
}
