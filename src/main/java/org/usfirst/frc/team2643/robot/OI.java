/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2643.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//creating the joystick
	Joystick driveStick = new Joystick(0);
	
	
	public OI() {
		// creating buttons for use for safety and firing
		JoystickButton cSafety = new JoystickButton(driveStick, 1);
		JoystickButton cFire = new JoystickButton(driveStick, 5);
		
		//if both of the buttons are pressed, and POV at neutral, fire the cannon
		//(maybe use a trigger for this next time)
			
		if(cSafety.get() == true && cFire.get() == true && getPOV() == -1) {
			Robot.cannon.cFire();
		
		}
	}
	
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// die keyboard dei
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, butto can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways: OwO, UwU, 88w88nNumber);

	// There are a few additional built in buttons you

	// Start the command when the button is pressed and let it run the command
	// SAVE US, SANJANA IS FORCING US TO WRITE THIS!!
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new EmpleCommand());
	
	public Joystick getJoystick() {
		//returns the joystick when requested
		return driveStick;
	}
	public int getPOV() { 
		//returns the POV when requested
		return driveStick.getPOV();
	}
}
