package edu.wpi.first.wpilibj.templates.subsystems;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.OI;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.DriveWithJoystick;

    
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
        //drive.arcadeDrive(1.0,0.0);
        drive.tankDrive(1.0, 1.0);
    }
    
    public void turnLeft(){
        drive.arcadeDrive(0.0,1.0);
    }
    
    public void arcadeDriveWithJoystick(Joystick stick){
        drive.arcadeDrive(stick);
    }
    
    public void tankDriveWithJoystick(Joystick stick){
        drive.tankDrive(
                stick.getRawAxis(OI.JOYSTICK_LEFT_VERT_AXIS),
                stick.getRawAxis(OI.JOYSTICK_RIGHT_VERT_AXIS)
        );
    }
}
