/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nutsandcolts.robot.commands.launcher;

import com.nutsandcolts.robot.commands.CommandBase;

/**
 *
 * @author Anthony
 */
public class PullBackLauncher extends CommandBase {
    
    private static final double setpoint = 0;
    
    public PullBackLauncher() {
        requires(launcher);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
//        launcher.enable();
//        launcher.setSetpoint(setpoint);
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
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
