package com.nutsandcolts.robot.commands.Launcher;

import com.nutsandcolts.robot.commands.CommandBase;

public class PullLauncher extends CommandBase {
    
    double speed;
    
    public PullLauncher() {
        this(0.5);
    }
    
    public PullLauncher(double speed) {
        requires(launcher);
        this.speed = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        launcher.set(speed);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return launcher.getSwitch();
    }

    // Called once after isFinished returns true
    protected void end() {
        launcher.set(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        launcher.set(0);
    }
}
