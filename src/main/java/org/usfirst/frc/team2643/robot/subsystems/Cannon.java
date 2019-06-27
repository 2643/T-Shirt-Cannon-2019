package org.usfirst.frc.team2643.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;


import org.usfirst.frc.team2643.robot.RobotMap;


import edu.wpi.first.wpilibj.Solenoid;

import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class Cannon extends Subsystem {
	WPI_TalonSRX cannonMotor;
	Solenoid cannonSolenoid;
	
	
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    }
    
    public void cannonUp(){
		cannonMotor.set(RobotMap.cannonUpSpeed);
	}
	
	public void cannonDown(){
		cannonMotor.set(RobotMap.cannonDownSpeed);
	}

	public void cannonStop(){
		cannonMotor.set(0);
	}

	public void fireSolenoid(){
		cannonSolenoid.set(true);
	}

	public void disengageSolenoid(){
		cannonSolenoid.set(false);
	}
}

