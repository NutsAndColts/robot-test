/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author Anthony
 */
public class CommandPneumatics extends CommandBase {
    
    private boolean value;
    
    public CommandPneumatics(boolean value) {
        requires(pneumatics);
        this.value = value;
    }

    protected void initialize() {
        pneumatics.set(value);
    }

    protected void execute() {
        
    }

    protected boolean isFinished() {
        
    }

    protected void end() {
        
    }

    protected void interrupted() {
        
    }
    
}
