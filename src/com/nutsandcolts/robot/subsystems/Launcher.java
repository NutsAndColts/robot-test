/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nutsandcolts.robot.subsystems;

import com.nutsandcolts.robot.RobotMap;
import com.nutsandcolts.robot.commands.launcher.ReleaseLauncher;
import edu.wpi.first.wpilibj.Gyro;
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
    
    private Gyro gyro = new Gyro(RobotMap.gyro);
    
    public Launcher() {
        super("Launcher", Kp, Ki, Kd);
    }
    
    public void initDefaultCommand() {
        setDefaultCommand(new ReleaseLauncher());
    }
    
    protected double returnPIDInput() {
        return gyro.pidGet();
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
