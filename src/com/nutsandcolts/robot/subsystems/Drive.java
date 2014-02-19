/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nutsandcolts.robot.subsystems;

import com.nutsandcolts.robot.RobotMap;
import com.nutsandcolts.robot.commands.DriveIdle;
import com.nutsandcolts.robot.commands.DriveWithJoystick;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Anthony
 */
public class Drive extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    RobotDrive drive;
    boolean reversed;
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new DriveWithJoystick());
    }
    
    public Drive() {
        reversed = true;
        reverse();
    }
    
    public void reverse(){
        if(reversed){
            //Make normal
            drive = new RobotDrive(RobotMap.leftMotor,RobotMap.rightMotor);
        } else {
            //Make reversed
            drive = new RobotDrive(RobotMap.rightMotor,RobotMap.leftMotor);
            drive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft,true);
            drive.setInvertedMotor(RobotDrive.MotorType.kFrontRight,true);
        }
        drive.setSafetyEnabled(false);
    }
    
    public void straight(){
        drive.arcadeDrive(1.0,0.0);
    }
    
    public void stop() {
        drive.arcadeDrive(0.0,0.0);
    }
    
    public void turnLeft(){
        drive.arcadeDrive(0.0,1.0);
    }
    
    public void driveWithJoystick(Joystick stick){
        drive.arcadeDrive(stick);
    }
}
