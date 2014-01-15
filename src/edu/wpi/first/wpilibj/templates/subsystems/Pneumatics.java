/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.pneumatics.SetPneumatics;

/**
 *
 * @author Anthony
 */
public class Pneumatics extends Subsystem {

    Relay solenoid = new Relay(RobotMap.solenoid);
    Relay compressor = new Relay(RobotMap.compressor);
    
    public void set(boolean value) {
        if(value) {
            solenoid.set(Relay.Value.kOn);
        } else {
            solenoid.set(Relay.Value.kOff);
        }
    }
    
    protected void initDefaultCommand() {
        setDefaultCommand(new SetPneumatics(false));
    }
    
}
