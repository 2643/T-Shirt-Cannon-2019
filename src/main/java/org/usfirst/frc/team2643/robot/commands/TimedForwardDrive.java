// /*----------------------------------------------------------------------------*/
// /* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
// /* Open Source Software - may be modified and shared by FRC teams. The code   */
// /* must be accompanied by the FIRST BSD license file in the root directory of */
// /* the project.                                                               */
// /*----------------------------------------------------------------------------*/

// package org.usfirst.frc.team2643.robot.commands;

// import org.usfirst.frc.team2643.robot.Robot;

// import edu.wpi.first.wpilibj2.command.TimedCommand;

// /**
//  * Add your docs here.
//  */
// public class TimedForwardDrive extends TimedCommand {
//   /**
//    * Add your docs here.
//    */
//   public TimedForwardDrive(double timeout) {
//     super(timeout);
//     addRequirements(Robot.drive);
//     // Use requires() here to declare subsystem dependencies
//     // eg. requires(chassis);
//   }

//   // Called just before this Command runs the first time
//   @Override
//   public void initialize() {
//   }

//   // Called repeatedly when this Command is scheduled to run
//   @Override
//   public void execute() {
//     Robot.drive.moveForward();
//   }

//   // Called once after timeout
//   @Override
//   public void end(boolean interrupted) {
//     Robot.drive.setSpeed(0);
//   }
// }
