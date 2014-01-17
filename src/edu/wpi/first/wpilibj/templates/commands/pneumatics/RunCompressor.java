/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.pneumatics;

import edu.wpi.first.wpilibj.templates.commands.CommandBase;

/**
 *
 * @author Zach Kimberg
 */
public class RunCompressor extends CommandBase {
    
    public RunCompressor() {
        requires(pneumatics);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        pneumatics.setCompressor(true);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        pneumatics.setCompressor(false);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
