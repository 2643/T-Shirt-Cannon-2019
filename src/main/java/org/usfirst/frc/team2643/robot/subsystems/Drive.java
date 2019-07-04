
package org.usfirst.frc.team2643.robot.subsystems;

import org.usfirst.frc.team2643.robot.RobotMap;
import org.usfirst.frc.team2643.robot.commands.TankDrive;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 * The drivetrain which allows the robot to move 
 */
public class Drive extends Subsystem {
	// Declaring the motors
	Spark lFrontMotor;
	Spark lBackMotor;
	Spark rFrontMotor; 
	Spark rBackMotor;

	/**
	 * The drivetrain which allows the robot to move
	 * @param leftFrontMotor (Spark)
	 * @param leftBackMotor (Spark)
	 * @param rightFrontMotor (Spark)
	 * @param rightBackMotor (Spark)
	 */
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
	
	/**
	 * Allows the robot to be controlled through a joystick with the
	 * 	 left joystick on the gamepad controlling the left side of the drivetrain and
	 * 	 the right joystick on the gamepad controlling the right side of the drivetrain
	 * @param stick (Joystick) the driver joystick used to control the drivetrain
	 */
    public void driveWithStick(Joystick stick) {
    	lFrontMotor.set(-stick.getRawAxis(RobotMap.leftAxis));
    	lBackMotor.set(-stick.getRawAxis(RobotMap.leftAxis));
    	rFrontMotor.set(stick.getRawAxis(RobotMap.rightAxis));
    	rBackMotor.set(stick.getRawAxis(RobotMap.rightAxis));
    	
    }
    
    
    
}

