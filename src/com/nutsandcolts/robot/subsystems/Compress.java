/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nutsandcolts.robot.subsystems;

import com.nutsandcolts.commands.pneumatics.IdleCompressor;
import com.nutsandcolts.robot.RobotMap;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Anthony
 */
public class Compress extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    Compressor compressor = new Compressor(RobotMap.compressorSwitch,RobotMap.compressorSpike);
    
    public void setCompressor(boolean value) {
        if(value) {
            compressor.start();
        } else {
            compressor.stop();
        }
    }
        
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new IdleCompressor());
    }
}
