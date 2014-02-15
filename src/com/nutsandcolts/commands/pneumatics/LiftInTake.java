package com.nutsandcolts.commands.pneumatics;

import com.nutsandcolts.robot.commands.CommandBase;

/**
 *
 * @author Anthony
 */
public class LiftInTake extends CommandBase {
    
    public LiftInTake() {
        requires(pneumatics);
    }

    protected void initialize() {
        pneumatics.setSolenoid(1);
    }

    protected void execute() {
        
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        
    }

    protected void interrupted() {
        
    }
    
}
