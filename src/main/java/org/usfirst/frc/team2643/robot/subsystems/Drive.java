
package org.usfirst.frc.team2643.robot.subsystems;

import org.usfirst.frc.team2643.robot.RobotMap;
import org.usfirst.frc.team2643.robot.commands.TankDrive;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drive extends Subsystem {
	// Declaring the motors
	Spark lFrontMotor = new Spark(RobotMap.lFrontMotor);
	Spark lBackMotor = new Spark(RobotMap.lBackMotor);
	Spark rFrontMotor = new Spark(RobotMap.rFrontMotor);
	Spark rBackMotor = new Spark(RobotMap.rBackMotor);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    	setDefaultCommand(new TankDrive());
    }
    
    public void driveWithStick(Joystick stick) {
    	// Sets motors equal to stick positions
    	lFrontMotor.set(stick.getRawAxis(1));
    	lBackMotor.set(stick.getRawAxis(1));
    	rFrontMotor.set(stick.getRawAxis(5));
    	rBackMotor.set(stick.getRawAxis(5));
    	
    }
    
    
    
}

