/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.LightsOff;
import edu.wpi.first.wpilibj.templates.commands.LightsOn;

/**
 *
 * @author Zach Kimberg
 */
public class Lights extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    Relay lights;
    
    public Lights(){
        lights = new Relay(RobotMap.lightSpikes);
    }
    
    public void set(boolean value){
        Relay.Value r;
        if(value){
            r = Relay.Value.kForward;
        } else {
            r = Relay.Value.kOff;
        }
        lights.set(r);
    };
    
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new LightsOff());
    }
}
