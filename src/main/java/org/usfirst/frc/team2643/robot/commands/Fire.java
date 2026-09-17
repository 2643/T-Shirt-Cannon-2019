/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2643.robot.commands;

import org.usfirst.frc.team2643.robot.Robot;
import org.usfirst.frc.team2643.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * Fires the cannon
 */
public class Fire extends CommandBase {
  Timer timer = new Timer(); 
  boolean finished = false; 

  public Fire() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    addRequirements(Robot.cannon);
  }

  // Called just before this Command runs the first time
  @Override
  public void initialize() {
    /* This piece of code makes sure that you can only fire when fully pressurized to 120 psi */
    
    // if(!Robot.cannon.fullyPressurized()){
    //   finished = true; 
    // }
    timer.reset(); 
    timer.start(); 
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
    Robot.cannon.fireSolenoid();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
    //fires the solenoid for a second and then retracts the solenoid
    if(timer.get() >= RobotMap.fireTime){
      finished = true; 
    }

    return finished; 
  }

  // Called once after isFinished returns true
  @Override
  public void end(boolean interrupted) {
    Robot.cannon.disengageSolenoid();
    finished = false; 
  }
}
