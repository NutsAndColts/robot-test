/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nutsandcolts.robot.commands;

/**
 *
 * @author Anthony
 */
public class DriveIntakeWithJoystick extends CommandBase {
    
    public DriveIntakeWithJoystick() {
        // Use requires() here to declare subsystem dependencies
        requires(intake);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        intake.driveWithJoystick(oi.getJoystick2());
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        intake.driveWithJoystick(oi.getJoystick2());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}