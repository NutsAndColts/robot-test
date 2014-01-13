/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nutsandcolts.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.nutsandcolts.robot.RobotMap;
import com.nutsandcolts.commands.pneumatics.SetPneumatics;

/**
 *
 * @author Anthony
 */
public class Pneumatics extends Subsystem {

    DoubleSolenoid solenoid = new DoubleSolenoid(RobotMap.solenoidForward, RobotMap.solenoidReverse);
    Relay compressor = new Relay(RobotMap.compressor);
    
    public void setSolenoid(boolean value) {
        if(value) {
            solenoid.set(DoubleSolenoid.Value.kForward);
        } else {
            solenoid.set(DoubleSolenoid.Value.kReverse);
        }
    }
    
    public void setCompressor(boolean value) {
        if(value) {
            compressor.set(Relay.Value.kOn);
        } else {
            compressor.set(Relay.Value.kOff);
        }
    }
    
    protected void initDefaultCommand() {
        setDefaultCommand(new SetPneumatics(false));
    }
    
}
