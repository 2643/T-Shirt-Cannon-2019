package org.usfirst.frc.team2643.robot.subsystems;

import org.usfirst.frc.team2643.robot.Robot;

import org.usfirst.frc.team2643.robot.RobotMap;
import org.usfirst.frc.team2643.robot.commands.CannonControl;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;

/**
 *
 */
public class Cannon extends Subsystem {
	Spark cMotor = new Spark(RobotMap.cMotor);
	Solenoid cSolenoid = new Solenoid(RobotMap.cSolesnoid);
	Potentiometer cPot = new AnalogPotentiometer(RobotMap.cPot, 360, 0);
	
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    	setDefaultCommand(new CannonControl());
    }
    
    public void cannonAimControl() {
    	// Sets cannon motor to 0 when hitting the soft stops and still trying to go past it
	    if((cannonPotWithinRange() == 1 && Robot.m_oi.getPOV() == 0) || (cannonPotWithinRange() == -1 && Robot.m_oi.getPOV() == 180)) {
	    	cMotor.set(0);
	    	// Sets motor to 0 when over the limit, ensuring nothing breaks
	    } else {
	    	// Values for POV are 0 to 315
	    	if(Robot.m_oi.getPOV() == 0) {
	    		cMotor.set(0.3);
	    	} else if(Robot.m_oi.getPOV() == 180) {
	    		cMotor.set(-0.3);
	    	} else {
	    		cMotor.set(0);
	    	}
	    }
    } 
    
    public int cannonPotWithinRange() {
    	//print the value of the potentiometer
    	System.out.println(cPot.get());
    	//check if the potentiometer is between the angles of 0 and 50 	
    	if(cPot.get() <= RobotMap.cSoftstopMin) {
    		return -1;
    	} else if(cPot.get() >= RobotMap.cSoftstopMax) {
    		return 1;
    	} else {
    		return 0;
    	}
    		
    }
    
    public void cFire() {
    	// Create a timer, keep the valve open for one second, then close it and reset the timer
    	Timer cTimer = new Timer();
    	cTimer.start();
    	while(cTimer.get() <= 1) {
    		cSolenoid.set(true);
    	}
    	cSolenoid.set(false);
    	cTimer.stop();
    	cTimer.reset();
    }
}

