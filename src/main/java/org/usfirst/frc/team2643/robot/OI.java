/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2643.robot;

import org.usfirst.frc.team2643.robot.commands.*;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Trigger;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//creating the joystick

	public Trigger fireTrigger = new FireTrigger();
	public Trigger upTrigger = new UpTrigger(); 
	public Trigger downTrigger = new DownTrigger();

	public JoystickButton autoStart = new JoystickButton(RobotMap.driveStick, 2);
	public JoystickButton autoKill = new JoystickButton(RobotMap.driveStick, 3);

	public OI() {
		fireTrigger.whenActive(new Fire());
		fireTrigger.whenInactive(new Waiting());
		upTrigger.whenActive(new CannonUp());
		upTrigger.whenInactive(new CannonStop());
		downTrigger.whenActive(new CannonDown());
		downTrigger.whenInactive(new CannonStop());

		autoStart.whenPressed(new ShowAuto1());
		autoKill.cancelWhenPressed(new ShowAuto1());
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
}
