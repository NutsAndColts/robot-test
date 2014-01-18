/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;


public class CommandLights extends CommandBase {
    
    int light;
    boolean value;
    boolean toggle;
    
    public CommandLights(int light, boolean value) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(lights);
        this.light = light;
        this.value = value;
        this.toggle = false;
    }
    
    public CommandLights(int light){
        requires(lights);
        this.light = light;
        this.toggle = true;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        if(toggle) lights.toggle(light);
        else lights.set(light, value);
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
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
