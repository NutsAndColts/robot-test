/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates.commands.pneumatics;

import edu.wpi.first.wpilibj.templates.commands.CommandBase;
import java.util.Timer;
import java.util.TimerTask;

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
        Timer timer = new Timer();
        pneumatics.setSolenoid(true);
        timer.schedule(new TimerTask() {
            public void run() {
                pneumatics.setSolenoid(false);
            }
        }, delay);
    }

    protected void execute() {

    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        pneumatics.setSolenoid(false);
    }

    protected void interrupted() {
        pneumatics.setSolenoid(false);
    }
    
}