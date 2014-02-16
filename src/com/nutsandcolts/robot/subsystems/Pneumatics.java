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

/**
 *
 * @author Anthony
 */
public class Pneumatics extends Subsystem {

    DoubleSolenoid solenoid = new DoubleSolenoid(RobotMap.solenoidForward, RobotMap.solenoidReverse);
    
    public void setSolenoid(int value) {
        if(value == 1) {
            solenoid.set(DoubleSolenoid.Value.kForward);
        } else if(value == -1) {
            solenoid.set(DoubleSolenoid.Value.kReverse);
        } else {
            solenoid.set(DoubleSolenoid.Value.kOff);
        }
    }
    
    protected void initDefaultCommand() {
        setDefaultCommand(new StopLift());
    }
    
}
