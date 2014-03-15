/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nutsandcolts.robot.subsystems;

import com.nutsandcolts.robot.Preseason2014;
import com.nutsandcolts.robot.RobotMap;
import com.nutsandcolts.robot.commands.IdleJaguar;
import edu.wpi.first.wpilibj.Gyro;
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
    Gyro gyro = new Gyro(RobotMap.gyro);
    
    public void set(double value){
        jag.set(value);
        Preseason2014.disp(2,"Angle: "+gyro.getAngle());
    }

    public void resetGyro(){
	    gyro.reset();
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new IdleJaguar());
    }

	public boolean isBack() {
		return gyro.getAngle()<-35;
	}
}
