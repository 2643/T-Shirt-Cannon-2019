
package org.usfirst.frc.team2643.robot.subsystems;

import org.usfirst.frc.team2643.robot.commands.TankDrive;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class Drive extends Subsystem {
	// Declaring the motors
	Spark lFrontMotor;
	Spark lBackMotor;
	Spark rFrontMotor; 
	Spark rBackMotor;

	public Drive(Spark leftFrontMotor, Spark leftBackMotor, Spark rightFrontMotor, Spark rightBackMotor){
		lFrontMotor = leftFrontMotor;
		lBackMotor = leftBackMotor; 
		rFrontMotor = rightFrontMotor; 
		rBackMotor = rightBackMotor; 
	}

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

