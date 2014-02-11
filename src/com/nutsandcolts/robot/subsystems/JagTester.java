/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nutsandcolts.robot.subsystems;

import com.nutsandcolts.robot.Preseason2014;
import com.nutsandcolts.robot.RobotMap;
import com.nutsandcolts.robot.commands.IdleJaguar;
import com.nutsandcolts.robot.commands.ZJaguar;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Zach Kimberg
 */
public class JagTester extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    Jaguar jag = new Jaguar(RobotMap.testJaguar);
    
    public void set(double value){
        double v = -.5*value+.5;
        Preseason2014.disp(3, "V: " + v);
        jag.set(v);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new IdleJaguar());
    }
}
