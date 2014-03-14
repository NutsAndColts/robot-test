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
public class CatapultBack extends CommandBase {
	
	public CatapultBack() {
        // Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(jagTester);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		jagTester.set(1.0);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		jagTester.set(1.0);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return jagTester.isBack();
	}

	// Called once after isFinished returns true
	protected void end() {
	}

    // Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
