/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Relay; //If your team uses victors, import them instead
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.SimpleRobot;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.visa.VisaException;

/**
 * This program sets up a basic robot, with two motors and encoders.
 * It then drives for five feet during teleop mode.
 * 
 */
public class EncoderDrive extends SimpleRobot 
{
    //Initializes the encoders
    //private final Encoder backLeft = new Encoder(1,2); 
    //private final Encoder backRight = new Encoder(4,3);
    
    //Motors
    Victor rightFrontMotor = new Victor( 6 );
    Victor rightBackMotor = new Victor( 9 );
    Victor leftFrontMotor = new Victor( 7 );
    Victor leftBackMotor = new Victor( 8 );
    Victor cannon = new Victor( 4 );
    
    //LED
    //LedController led = new LedController(100);
    
    //timer
    Timer timer = new Timer();
    //This is actually useless and should be removed
    
    //Initializes the drive
    RobotDrive drive = new RobotDrive(leftFrontMotor, leftBackMotor, rightFrontMotor, rightBackMotor);
    
    //Joysticks 
    Joystick Controller = new Joystick(1); 

    //Relay / Compressor
    Relay release = new Relay(8);
    Compressor compressor = new Compressor( 5 , 7 );
    
    //misc
    double speedForward = 0.35;
    double speedBackward = -.35;
    
    //Arduino arduino = new Arduino();
    
    public boolean autoCompressor;
    
    public int shootState = 0;
    public final int idle = 0;
    public final int charging = 1;
    public final int fired = 2;
    
    public static int shootToggler1 = 9;
    public static int shootToggler2 = 6;
    public static int shootToggler3 = 12;
    
    //static boolean gamePadToggler = true;
    static int compressorToggleOn = 1;
    static int compressorToggleOff = 3;
    static int cannonUp = 4;
    static int cannonDown = 2;
    static int state = 0;
    
    
    public EncoderDrive()
    {
        System.out.println( "Code enabled" );
        //arduino.send( 'd' );
      
        drive.setInvertedMotor( RobotDrive.MotorType.kFrontLeft , true );
        drive.setInvertedMotor( RobotDrive.MotorType.kFrontRight , true );
        drive.setInvertedMotor( RobotDrive.MotorType.kRearLeft , true );
        drive.setInvertedMotor( RobotDrive.MotorType.kRearRight , true );
        drive.setSafetyEnabled( false );
        //Starts the encoders
        //backLeft.start();
        //backRight.start();
        
        //Sets distance in inches
        //This was obtained by finding the circumfrance of the wheels,
        //finding the number of encoder pulses per rotation,
        //and diving the circumfrance by that number.
        //backLeft.setDistancePerPulse(.000623);
        //backRight.setDistancePerPulse(.000623);
    }

    /**
     * This function is called once each time the robot enters operator control.
     */
    
    public void operatorControl()
    {
        compressor.start();
        autoCompressor = true;
        
        while( isOperatorControl() && isEnabled() )
        {
            drive.arcadeDrive( Controller );
            
            switch(state)
            {
                case 0:
                    System.out.println("Test1");
                    if(Controller.getRawButton(4))
                    {
                        state = 1;
                    }
                    break;
                   
                case 1:
                    System.out.println("Test2");
                    if(Controller.getRawButton(2))
                    {
                        state = 0;
                    }
                    break;
            }
            
            
            if( Controller.getRawButton(shootToggler1) && Controller.getRawButton( shootToggler2 ))
    
                
                
//This is a safety feature//
            {
              release.set( Relay.Value.kOn );
              System.out.println("Firing");
            }
            else
            {
              release.set( Relay.Value.kOff );
              //System.out.println("idling");
            }
                     
            if( autoCompressor && Controller.getRawButton( compressorToggleOff ) )
              {
                autoCompressor = false;
                compressor.stop();
                System.out.println("Compressor Off");
              }
            else if( !autoCompressor && Controller.getRawButton( compressorToggleOn ) )
              {
                autoCompressor = true;
                compressor.start();
                System.out.println("Compressor On");
              }
           
            //Button 2 moves the cannon down and Button 3 moves the cannon up
            if( Controller.getRawButton(cannonDown) )
            {
               cannon.set( speedForward );
               System.out.println("Moving down");
            }
            else if( Controller.getRawButton(cannonUp) )
            {
                cannon.set(speedBackward);
                System.out.println("Moving up");
            }
            else
            {
                cannon.set(0);
            }                    
        }
    }
}