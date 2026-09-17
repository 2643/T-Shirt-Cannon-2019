package org.usfirst.frc.team2643.robot.commands;

import org.usfirst.frc.team2643.robot.Robot;
import org.usfirst.frc.team2643.robot.RobotMap;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class TankDrive extends CommandBase {
    public TankDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	addRequirements(Robot.drive);
    }

    // Called just before this Command runs the first time
    public void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    public void execute() {
    	// Runs code in Robot.java
    	Robot.drive.driveWithStick(RobotMap.driveStick);
    }

    // Make this return true when this Command no longer needs to run execute()
    public boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    public void end(boolean interrupted) {
    	
    	// Because there is no autonomous, the only command running in the drive system will be tank drive
    }
}
