/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2643.robot.subsystems;

import org.usfirst.frc.team2643.robot.Robot;
import org.usfirst.frc.team2643.robot.RobotMap;
import org.usfirst.frc.team2643.robot.commands.Compressing;

import edu.wpi.first.wpilibj.Relay.Direction;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */		
public class Cannon extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public Cannon(){
    RobotMap.relay.setDirection(Direction.kForward);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new Compressing());
  }

  /**
	 * Fires the solenoid
	 */
	public void fireSolenoid(){
		RobotMap.cSolenoid.set(true);
	}

	/**
	 * Retracts the solenoid
	 */
	public void disengageSolenoid(){
		RobotMap.cSolenoid.set(false);
  }
  

	/**
	 * checks if the compressor is low
	 * @return boolean true if NOT low on pressure
	 * THE DOCUMENTATION IS CRAP
	 */
	public boolean low(){
		if(RobotMap.compressor.getPressureSwitchValue())
			return true; 
		return false; 
	}
}
