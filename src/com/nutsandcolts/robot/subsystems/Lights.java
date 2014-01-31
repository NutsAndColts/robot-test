/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nutsandcolts.robot.subsystems;

import com.nutsandcolts.robot.RobotMap;
import com.nutsandcolts.robot.commands.LightsOff;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Zach Kimberg
 */
public class Lights extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    Relay lights;
    Servo laser;
    
    public Lights(){
        lights = new Relay(RobotMap.lightsSpike);
        laser = new Servo(RobotMap.laserServo);
    }
    
    public void setLights(boolean value){
        Relay.Value r;
        if(value) r = Relay.Value.kOn;
        else r = Relay.Value.kOff;
        lights.set(r);
    }
    
    public void setLaser(double value){
        laser.set(-.5*value+.5);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        //setDefaultCommand(new LightsOff());
    }
}
