/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.commands.CommandLights;

/**
 *
 * @author Zach Kimberg
 */
public class Lights extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    Relay[] lightsArray;
    
    public Lights(){
        lightsArray = new Relay[3];
        for(int i=0; i<lightsArray.length; i++){
            lightsArray[i].set(Relay.Value.kOff);
        }
    }
    
    public void set(int light, boolean value){
        Relay.Value r;
        if(value){
            r = Relay.Value.kOn;
        } else {
            r = Relay.Value.kOff;
        }
        lightsArray[light].set(r);
    };
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new CommandLights(0,false));
    }
}
