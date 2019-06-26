package org.usfirst.frc.team2643.robot.commands;

import org.usfirst.frc.team2643.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TankDrive extends Command {

	
	
    public TankDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	// Runs code in Robot.java
    	Robot.drive.driveWithStick(Robot.m_oi.getJoystick());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	
    	// Because there is no autonomous, the only command running in the drive system will be tank drive
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
