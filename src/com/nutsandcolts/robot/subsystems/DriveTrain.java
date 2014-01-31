package com.nutsandcolts.robot.subsystems;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.nutsandcolts.robot.RobotMap;
import com.nutsandcolts.robot.commands.DriveWithJoystick;

    
/**
 *
 * @author Zach
 */
public class DriveTrain extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    RobotDrive drive;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new DriveWithJoystick());
    }
    
    public DriveTrain(){
        drive = new RobotDrive(RobotMap.leftMotor,RobotMap.rightMotor);
        drive.setSafetyEnabled(false);
    }
    
    public void straight(){
        drive.arcadeDrive(1.0,0.0);
    }
    
    public void turnLeft(){
        drive.arcadeDrive(0.0,1.0);
    }
    
    public void driveWithJoystick(Joystick stick){
        drive.arcadeDrive(stick);
    }
}
