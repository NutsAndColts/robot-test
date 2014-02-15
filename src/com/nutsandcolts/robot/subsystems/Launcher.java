/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nutsandcolts.robot.subsystems;

import com.nutsandcolts.robot.Preseason2014;
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
    
    private Jaguar motor = new Jaguar(RobotMap.launcherMotor);
    private Gyro gyro = new Gyro(RobotMap.gyro);
    
    public Launcher() {
        super("Launcher", Kp, Ki, Kd);
        enable();
    }
    
    public void initDefaultCommand() {
        setDefaultCommand(new ReleaseLauncher());
    }
    
    protected double returnPIDInput() {
        Preseason2014.disp(2, "Gyro angle: " + gyro.getAngle());
        Preseason2014.disp(3, "Gyro pidGet: " + gyro.pidGet());
        Preseason2014.disp(4, "millis: " + System.currentTimeMillis());
        return gyro.pidGet();
    }
    
    protected void usePIDOutput(double output) {
        motor.pidWrite(output);
    }
    
    public void releaseMotor() {
        motor.set(0);
    }
    
    public void setMotor(double value) {
        motor.set(value);
    }
    
}
