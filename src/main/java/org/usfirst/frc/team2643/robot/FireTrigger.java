/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2643.robot;

import org.usfirst.frc.team2643.robot.Robot;

import edu.wpi.first.wpilibj.buttons.Trigger;

/**
 * Add your docs here.
 */
public class FireTrigger extends Trigger {
  public FireTrigger(){

  }
  
  @Override
  public boolean get() {
    return Robot.m_oi.driveStick.getRawButton(1) && Robot.m_oi.driveStick.getRawButton(5) && Robot.m_oi.driveStick.getPOV() == -1;
  }
}
