/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nutsandcolts.commands.pneumatics;

import com.nutsandcolts.robot.commands.CommandBase;

/**
 *
 * @author Zach Kimberg
 */
public class ActuatePneumatics extends CommandBase {

    private long delay; // in milliseconds
    
    public ActuatePneumatics(long delay) {
        this.delay = delay;
    }
    
    protected void initialize() {
        pneumatics.setSolenoid(true);
        setTimeout(delay / 1000.0);
    }

    protected void execute() {

    }

    protected boolean isFinished() {
        return isTimedOut();
    }

    protected void end() {
        pneumatics.setSolenoid(false);
    }

    protected void interrupted() {
        end();
    }
    
}