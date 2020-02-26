
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
    	setDefaultCommand(new TankDrive());
    }
	
	/**
	 * Allows the robot to be controlled through a joystick with tank drive
	 * @param stick (Joystick) the driver joystick used to control the drivetrain
	 */
    public void driveWithStick(Joystick stick) {
    	lFrontMotor.set(-stick.getRawAxis(RobotMap.leftAxis));
    	lBackMotor.set(-stick.getRawAxis(RobotMap.leftAxis));
    	rFrontMotor.set(stick.getRawAxis(RobotMap.rightAxis));
    	rBackMotor.set(stick.getRawAxis(RobotMap.rightAxis));	
    }
	
	/**
	 * Set the motors to go forward/backward at a set speed between -1 and 1
	 * @param speed int between -1 and 1
	 */
	public void setSpeed(double speed){
		lFrontMotor.set(-speed);
		lBackMotor.set(-speed);
		rFrontMotor.set(speed);
		rBackMotor.set(speed);
	}

	/**
	 * Move the robot forward at the auto drive speed specified in RobotMap
	 */
	public void moveForward(){
		setSpeed(RobotMap.autoDriveSpeed);
	}

	/**
	 * Move the robot backward at the auto drive speed specified in RobotMap
	 */
	public void moveBackward(){
		setSpeed(-RobotMap.autoDriveSpeed);
	}
    
    
}

