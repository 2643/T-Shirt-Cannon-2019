package org.usfirst.frc.team2643.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import org.usfirst.frc.team2643.robot.RobotMap;
import org.usfirst.frc.team2643.robot.commands.CannonStop;

import edu.wpi.first.wpilibj.command.Subsystem;


/**
 * The subsystem that launches the t shirt at various angles
 */
public class CannonPositioner extends Subsystem {
	WPI_TalonSRX cannonMotor;

	/**
	 * The cannon which launches the t shirt, utilizing a  single solenoid to fire and a motor to adjust the angle
	 */
	public CannonPositioner(WPI_TalonSRX motorForCannon){
		cannonMotor = motorForCannon; 

	}

    public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand(new CannonStop());
    }
	
	/**
	 * Makes the angle of launch of the cannon higher
	 */
    public void cannonUp(){
		cannonMotor.set(RobotMap.cannonUpSpeed);
	}
	
	/**
	 * Makes the angle of launch of the cannon lower
	 */
	public void cannonDown(){
		cannonMotor.set(RobotMap.cannonDownSpeed);
	}

	
	/**
	 * Stops the cannon and hopefully holds it in place
	 */
	public void cannonStop(){
		cannonMotor.set(0);
	}

	/**
	 * Returns the value of the potentiometer on the cannon
	 */
	public double getPotentiometer(){
		return RobotMap.cannonPot.get(); 
	}

}

