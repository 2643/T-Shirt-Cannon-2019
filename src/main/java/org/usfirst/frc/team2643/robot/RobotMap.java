/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2643.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	public static Spark lFrontMotor = new Spark(2);
	public static Spark lBackMotor = new Spark(3);
	public static Spark rFrontMotor = new Spark(1);
	public static Spark rBackMotor = new Spark(4);
	  
	static WPI_TalonSRX cMotor = new WPI_TalonSRX(2);
	public static Solenoid cSolenoid = new Solenoid(0);

	public static Relay relay = new Relay(0);
	public static Compressor compressor = new Compressor();

	//turning towards the front decreases the value of the pot
	//turning towards the back increases teh value of the pot 
	public static Potentiometer cannonPot = new AnalogPotentiometer(0, 360 , 30);
	
	public static double cannonUpSpeed = 0.3;
	public static double cannonDownSpeed = -0.3; 

	public static double cannonUpperLimit = 237; //shooting down
	public static double cannonLowerLimit = 247; //shooting up //247 with inertia ended up hitting the tank

	public static boolean lowPressure = false;

	public static double autoDriveSpeed = 0.4;
	public static int fireTime = 1; 

	public static Joystick driveStick = new Joystick(0);
	public static int leftAxis = 1;
	public static int rightAxis = 5; 
	
	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}
