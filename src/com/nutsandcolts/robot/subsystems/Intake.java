/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nutsandcolts.robot.subsystems;

import com.nutsandcolts.robot.RobotMap;
import com.nutsandcolts.robot.commands.IntakeIdle;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Anthony
 */
public class Intake extends Subsystem {
    
    Relay intake;
    
    public Intake() {
        intake = new Relay(RobotMap.intakeMotor);
    }
    
    public void set(boolean value) {
        Relay.Value r;
        if(value) {
            r = Relay.Value.kForward;
        } else {
            r = Relay.Value.kOff;
        }
        intake.set(r);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new IntakeIdle());
    }
}
