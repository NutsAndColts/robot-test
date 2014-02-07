/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nutsandcolts.robot.subsystems;

import com.nutsandcolts.robot.RobotMap;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 * @author Anthony
 */
public class Launcher extends PIDSubsystem {

    private static final double Kp = 1.0;
    private static final double Ki = 0.0;
    private static final double Kd = 0.0;
    
    private Jaguar motorOne = new Jaguar(RobotMap.launcherMotorOne);
    private Jaguar motorTwo = new Jaguar(RobotMap.launcherMotorTwo);
    
    // Initialize your subsystem here
    public Launcher() {
        super("Launcher", Kp, Ki, Kd);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
        return 0.0;
    }
    
    protected void usePIDOutput(double output) {
        motorOne.pidWrite(output);
        motorTwo.pidWrite(output);
    }
    
    public void releaseMotors() {
        motorOne.set(0);
        motorTwo.set(0);
    }
    
}
