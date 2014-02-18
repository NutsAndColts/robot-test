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
import com.nutsandcolts.commands.pneumatics.StopLift;
import edu.wpi.first.wpilibj.Compressor;

/**
 *
 * @author Anthony
 */
public class Pneumatics extends Subsystem {

    DoubleSolenoid solenoid = new DoubleSolenoid(RobotMap.solenoidForward, RobotMap.solenoidReverse);
    Compressor compressor = new Compressor(RobotMap.compressorSwitch,RobotMap.compressorSpike);
    Relay stopper = new Relay(RobotMap.stopper);
    
    public Pneumatics(){
        compressor.start();
    }
    
    public void setSolenoid(int value) {
        if(value == 1) {
            solenoid.set(DoubleSolenoid.Value.kForward);
        } else if(value == -1) {
            solenoid.set(DoubleSolenoid.Value.kReverse);
        } else {
            solenoid.set(DoubleSolenoid.Value.kOff);
        }
    }
    
    public void setStopper(boolean value){
        if(value == true) {
            stopper.set(Relay.Value.kForward);
        } else {
            stopper.set(Relay.Value.kOff);
        }
    }
    
    protected void initDefaultCommand() {
        setDefaultCommand(new StopLift());
    }
    
}
