package com.nutsandcolts.robot.subsystems;

import com.nutsandcolts.robot.RobotMap;
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
    
    public void initDefaultCommand() {
        setDefaultCommand(new DriveWithJoystick());
    }
    
    public Drive() {
        drive = new RobotDrive(RobotMap.leftMotor, RobotMap.rightMotor);
        drive.setSafetyEnabled(false);
    }
    
    public void straight(){
        drive.arcadeDrive(-1.0, 0.0);
    }
    
    public void stop() {
        drive.arcadeDrive(0.0, 0.0);
    }
    
    public void turnLeft(){
        drive.arcadeDrive(0.0, 1.0);
    }
    
    public void driveWithJoystick(Joystick stick) {
        drive.arcadeDrive(stick);
    }
}