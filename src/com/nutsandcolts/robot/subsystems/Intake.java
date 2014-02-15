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
    
    public void set(int value) {
        Relay.Value r = null;
        if(value == 1) {
            r = Relay.Value.kForward;
        } else if(value == -1) {
            r = Relay.Value.kReverse;
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
