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
        pneumatics.set(false);
    }

    protected void execute() {
        Timer timer = new Timer();
        pneumatics.set(true);
        timer.schedule(new TimerTask() {
            public void run() {
                pneumatics.set(false);
            }
        }, delay);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        pneumatics.set(false);
    }

    protected void interrupted() {
        pneumatics.set(false);
    }
    
}