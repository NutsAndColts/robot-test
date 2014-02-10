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
public class PowerLauncher extends CommandBase {
    
    public PowerLauncher() {
        requires(launcher);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        launcher.setMotor(oi.getJoystick().getRawAxis(3) * -0.5 + 0.5);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        launcher.setMotor(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        launcher.setMotor(0);
    }
}
