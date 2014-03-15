/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nutsandcolts.robot.commands;

/**
 *
 * @author Zach Kimberg
 */
public class ResetGyro extends CommandBase {
	
	public ResetGyro() {
        // Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(jagTester);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		jagTester.resetGyro();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return true;
	}

	// Called once after isFinished returns true
	protected void end() {
		jagTester.resetGyro();
	}

    // Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
